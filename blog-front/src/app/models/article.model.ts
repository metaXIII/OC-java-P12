import {Tag} from "./tag.model"

export class Article {
  constructor(
    public titre: string,
    public synopsis: string,
    public  content: string,
    public tags : Tag,
    public localDate: Date
  ) {
  }
}
