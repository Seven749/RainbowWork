package com.seven749.rainbowwork.bean;

import androidx.annotation.StringDef;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumBean {
    /**
     * {
     *             "name": "青年节：致逐梦人，有志者事竟成",
     *             "id": 4965675848,
     *             "trackNumberUpdateTime": 1586864161140,
     *             "status": 0,
     *             "userId": 1548006936,
     *             "createTime": 1586706081233,
     *             "updateTime": 1586864161140,
     *             "subscribedCount": 2319,
     *             "trackCount": 43,
     *             "cloudTrackCount": 0,
     *             "coverImgUrl": "http://p1.music.126.net/cc478JioCBSRUNZIomStJA==/109951164898577582.jpg",
     *             "coverImgId": 109951164898577580,
     *             "description": "奔跑吧！骄傲的少年！\n\n无论你今年多大\n20岁，30岁，还是40岁\n只要一颗不服输的心!\n永远是最年轻那个人!\n\n作为新时代有志青年!\n我们要撸起袖子加油干!\n\n致敬所有努力拼搏追逐梦想的人，无论你是学生、还是工人、还是医生、还是老师等等.......\n努力向上的你们真棒，你们最美！",
     *             "tags": [
     *                 "华语",
     *                 "治愈",
     *                 "流行"
     *             ],
     *             "playCount": 267983,
     *             "trackUpdateTime": 1588385337745,
     *             "specialType": 0,
     *             "totalDuration": 0,
     *             "creator": {
     *                 "defaultAvatar": false,
     *                 "province": 1000000,
     *                 "authStatus": 0,
     *                 "followed": false,
     *                 "avatarUrl": "http://p1.music.126.net/RwnvDOZdn81dysWYa_CWXQ==/109951164488268681.jpg",
     *                 "accountStatus": 0,
     *                 "gender": 1,
     *                 "city": 1005300,
     *                 "birthday": 1001379618554,
     *                 "userId": 1548006936,
     *                 "userType": 200,
     *                 "nickname": "真咸鱼饼干",
     *                 "signature": "做自己喜欢的事情，听自己喜欢的歌，不用在乎别人说什么，我就是我自己。",
     *                 "description": "",
     *                 "detailDescription": "",
     *                 "avatarImgId": 109951164488268690,
     *                 "backgroundImgId": 109951164570474880,
     *                 "backgroundUrl": "http://p1.music.126.net/iXyV-OWi8uxwgfagJGiJlA==/109951164570474887.jpg",
     *                 "authority": 0,
     *                 "mutual": false,
     *                 "expertTags": [
     *                     "欧美"
     *                 ],
     *                 "experts": null,
     *                 "djStatus": 0,
     *                 "vipType": 11,
     *                 "remarkName": null,
     *                 "avatarImgIdStr": "109951164488268681",
     *                 "backgroundImgIdStr": "109951164570474887",
     *                 "avatarImgId_str": "109951164488268681"
     *             },
     *             "tracks": null,
     *             "subscribers": [
     *                 {
     *                     "defaultAvatar": false,
     *                     "province": 410000,
     *                     "authStatus": 0,
     *                     "followed": false,
     *                     "avatarUrl": "http://p1.music.126.net/1AcPhPo9C0MEP0Au0UWoEw==/109951164913552468.jpg",
     *                     "accountStatus": 0,
     *                     "gender": 1,
     *                     "city": 410100,
     *                     "birthday": -2209017600000,
     *                     "userId": 2045454685,
     *                     "userType": 0,
     *                     "nickname": "永恒-Q",
     *                     "signature": "",
     *                     "description": "",
     *                     "detailDescription": "",
     *                     "avatarImgId": 109951164913552460,
     *                     "backgroundImgId": 109951164929306340,
     *                     "backgroundUrl": "http://p1.music.126.net/cpsTgHkOLP0hL4j0id6l2Q==/109951164929306341.jpg",
     *                     "authority": 0,
     *                     "mutual": false,
     *                     "expertTags": null,
     *                     "experts": null,
     *                     "djStatus": 0,
     *                     "vipType": 0,
     *                     "remarkName": null,
     *                     "avatarImgIdStr": "109951164913552468",
     *                     "backgroundImgIdStr": "109951164929306341",
     *                     "avatarImgId_str": "109951164913552468"
     *                 }
     *             ],
     *             "subscribed": null,
     *             "commentThreadId": "A_PL_0_4965675848",
     *             "newImported": false,
     *             "adType": 0,
     *             "highQuality": false,
     *             "privacy": 0,
     *             "ordered": true,
     *             "anonimous": false,
     *             "coverStatus": 3,
     *             "recommendInfo": null,
     *             "shareCount": 95,
     *             "coverImgId_str": "109951164898577582",
     *             "commentCount": 39,
     *             "alg": "alg_sq_featured"
     *         }
     */

    private String name;
    private String id;
    private String coverImgUrl;
    private String description;
    private String nickName;
    private String userId;

    public AlbumBean(String name, String id, String coverImgUrl, String description, String nickName, String userId) {
        this.name = name;
        this.id = id;
        this.coverImgUrl = coverImgUrl;
        this.description = description;
        this.nickName = nickName;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUserId() {
        return userId;
    }
}
