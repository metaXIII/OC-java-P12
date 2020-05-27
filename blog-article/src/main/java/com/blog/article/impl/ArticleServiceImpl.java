package com.blog.article.impl;

import com.blog.article.dto.ArticleDto;
import com.blog.article.dto.ArticleUpdateDto;
import com.blog.article.exception.ArticleException;
import com.blog.article.model.Article;
import com.blog.article.model.Tags;
import com.blog.article.proxy.GatewayProxy;
import com.blog.article.repository.ArticleRepository;
import com.blog.article.repository.ArticleRepositoryPage;
import com.blog.article.service.IArticleService;
import com.blog.article.service.ITagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepositoryPage articleRepositoryPage;

    private final ArticleRepository articleRepository;

    private final GatewayProxy gatewayProxy;

    private final ITagService tagService;

    @Override
    public List<Article> findAllForPageLimit(int page, int number) {
        return articleRepositoryPage.findAll(PageRequest.of(page, number)).toList();
    }

    @Override
    public List<Article> findAll() {
        return (List<Article>) articleRepositoryPage.findAll();
    }

    @Override
    public Article findById(long id) throws ArticleException {
        Optional<Article> article = articleRepositoryPage.findById((int) id);
        if (article.isPresent())
            return article.get();
        else {
            String err = "L'article n'est pas présent dans la base de donnée";
            log.error(err + " : " + id);
            throw new ArticleException(err);
        }
    }

    @Override
    public void insert(ArticleDto articleDto) throws UserPrincipalNotFoundException {
        try {
            if (gatewayProxy.userExist(articleDto.getControl()).getBody()) {
                Article article = new Article();
                Tags    tags    = new Tags();
                tags.setTag(articleDto.getTags() != null ? articleDto.getTags() : "");
                tags = tagService.save(tags);
                article.setTags(tags);
                article.setTitre(articleDto.getTitre() != null ? articleDto.getTitre() : "");
                article.setSynopsis(articleDto.getSynopsis() != null ? articleDto.getSynopsis() : "");
                article.setContent(articleDto.getContent() != null ? articleDto.getContent() : "");
                article.setLocalDate(LocalDate.now());
                articleRepositoryPage.save(article);
                try {
                    gatewayProxy.sendEmail(article);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            } else
                throw new UserPrincipalNotFoundException("L'utilisateur n'est pas disponible ou n'existe pas");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<Article> findByCategorie(String category) {
        return articleRepositoryPage.findByTags_TagContaining(category);
    }

    @Override
    public List<Article> findAllForAdmin() {
        return articleRepository.findAll();
    }

    @Override
    public void update(ArticleUpdateDto articleUpdateDto) {
        try {
            if (gatewayProxy.userExist(articleUpdateDto.getControl()).getBody()) {
                Article article = new Article();
                Tags    tags    = new Tags();
                tags.setTag(articleUpdateDto.getTags() != null ? articleUpdateDto.getTags() : "");
                tags = tagService.save(tags);
                article.setId(articleUpdateDto.getId());
                article.setTags(tags);
                article.setTitre(articleUpdateDto.getTitre() != null ? articleUpdateDto.getTitre() : "");
                article.setSynopsis(articleUpdateDto.getSynopsis() != null ? articleUpdateDto.getSynopsis() : "");
                article.setContent(articleUpdateDto.getContent() != null ? articleUpdateDto.getContent() : "");
                article.setLocalDate(LocalDate.now());
                articleRepositoryPage.save(article);
            } else
                throw new UserPrincipalNotFoundException("L'utilisateur n'est pas disponible ou n'existe pas");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
