package com.seven749.rainbowwork.bean;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumItem {
    /**
     * {
     *             "subscribers": [],
     *             "subscribed": false,
     *             "creator": {
     *                 "defaultAvatar": false,
     *                 "province": 500000,
     *                 "authStatus": 0,
     *                 "followed": false,
     *                 "avatarUrl": "http://p1.music.126.net/R9EeOr5a0oaneB5X__WFhA==/109951164485016413.jpg",
     *                 "accountStatus": 0,
     *                 "gender": 0,
     *                 "city": 500101,
     *                 "birthday": -2209017600000,
     *                 "userId": 1325443351,
     *                 "userType": 0,
     *                 "nickname": "柒乘七",
     *                 "signature": "",
     *                 "description": "",
     *                 "detailDescription": "",
     *                 "avatarImgId": 109951164485016420,
     *                 "backgroundImgId": 109951164196445600,
     *                 "backgroundUrl": "http://p1.music.126.net/Gg-YttSbEAbRrc3X3a7uww==/109951164196445597.jpg",
     *                 "authority": 0,
     *                 "mutual": false,
     *                 "expertTags": null,
     *                 "experts": null,
     *                 "djStatus": 0,
     *                 "vipType": 11,
     *                 "remarkName": null,
     *                 "avatarImgIdStr": "109951164485016413",
     *                 "backgroundImgIdStr": "109951164196445597",
     *                 "avatarImgId_str": "109951164485016413"
     *             },
     *             "artists": null,
     *             "tracks": null,
     *             "updateFrequency": null,
     *             "backgroundCoverId": 0,
     *             "backgroundCoverUrl": null,
     *             "titleImage": 0,
     *             "titleImageUrl": null,
     *             "englishTitle": null,
     *             "opRecommend": false,
     *             "recommendInfo": null,
     *             "ordered": true,
     *             "tags": [],
     *             "createTime": 1514612225018,
     *             "highQuality": false,
     *             "userId": 1325443351,
     *             "trackCount": 8,
     *             "playCount": 89,
     *             "trackNumberUpdateTime": 1588432536016,
     *             "coverImgId": 109951163887205680,
     *             "newImported": false,
     *             "anonimous": false,
     *             "updateTime": 1588432931176,
     *             "specialType": 5,
     *             "commentThreadId": "A_PL_0_2035154238",
     *             "privacy": 0,
     *             "trackUpdateTime": 1588438476304,
     *             "coverImgUrl": "https://p2.music.126.net/l9X70MdRlLbbHhbk-FX33A==/109951163887205686.jpg",
     *             "totalDuration": 0,
     *             "adType": 0,
     *             "description": null,
     *             "status": 0,
     *             "subscribedCount": 0,
     *             "cloudTrackCount": 0,
     *             "name": "柒乘七喜欢的音乐",
     *             "id": 2035154238,
     *             "coverImgId_str": "109951163887205686"
     *         }
     */

    String name;
    String id;
    String coverImgUrl;
    String nickname;

    public AlbumItem(String name, String id, String coverImgUrl, String nickname) {
        this.name = name;
        this.id = id;
        this.coverImgUrl = coverImgUrl;
        this.nickname = nickname;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
