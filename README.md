# ChuMeet
Build by Eclipse,For BA103g2 Team share;

# 1.開發說明

 1.先用您的GitHub帳號Fork一份到您那兒~,編碼統一為UTF-8
 
 2.提交commit and push到你自己的帳號專案中
 
 3.在自己的專案用Pull request提交到我這裡,我做總整理,ok就會合併～感謝惹～
 
 4.盡量在現有程式中間加寫檔案,地址轉換統一管理在WEB-INF下的web.xml之中加寫
 
 5.模板是Template.jsp這一隻,可以放在任何地方,根據你要的內容撰寫在放在自己的資料夾下面
 
# 2.目錄結構

    ChuMeetWebsite/
    │
    ├── WebContent/
    │   ├── WEB-INF -註冊路徑用,注意別打錯,會報錯。
    │   ├── HTML -只存放網頁資料,即時更新對應最新的頁面內容
    │   ├── front-end -只存放<前端>畫面用的<JSP>,取用資料全來自於HTML資料夾下
    │   ├── back-end -只存放<後端>畫面用的<JSP>,取用資料全來自於HTML資料夾下
    │   └── Template.jsp -模板 
    │
    ├── src/
    │   ├── com/member/
    │   │            ├── controller -放我會員用的Servlet程式,對應Web.xml與JSP交互操作。
    │   │            ├── model -放會員相關Model,依序為VO(DTO),DAO(Interface),JDBCDAO(測試類),DAO(Impl,JNDI類),Service(業務邏輯)。
    │   │            └── ........ 更多
    │   ├── com/act/
    │   │         ├── ...
    │   │         ├── ...
    │   │         └── ...
    │   │  
    │   └── com/club/
    │             ├── ...
    │             ├── ...
    │             └── ...
    │
    └─── README.md -說明文件
 
# 3.直接clone到你那邊測試

 1.記得處理jar檔依賴問題
 
 2.記得配置自己Tomcat中context.xml裡的DataSource連線設定
 
