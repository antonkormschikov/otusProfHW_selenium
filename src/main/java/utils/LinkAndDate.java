package utils;

import java.time.LocalDate;

public class LinkAndDate {
  String link = null;
  LocalDate date;

  public LinkAndDate(String link, LocalDate date) {
    this.link = link;
    this.date = date;
  }

  public String getLink() {
    return link;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public static LinkAndDate max(LinkAndDate x, LinkAndDate y){
    return x.getDate().isAfter(y.getDate()) ? x : y;
  }

}
