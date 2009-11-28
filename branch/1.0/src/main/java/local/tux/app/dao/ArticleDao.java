package local.tux.app.dao;

import java.util.Date;
import java.util.List;

import local.tux.app.model.News;

public interface ArticleDao extends TuxNameGenericDao<News, Long>{
	public List<News> getArticlesByDate(Date from);

}
