package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {


    public int findCountByRid(int rid);

    public Favorite findByRidAndUid(int rid, int uid);

    void add(int rid, int uid);
}
