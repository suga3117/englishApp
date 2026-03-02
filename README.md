●えーたん

個人作成したポートフォリオです。

・英語学習の単語学習時に使用するサイトです。

●アプリ内容
・英語学習時に単語を調べたり、単語帳を作成しわからない単語を単語帳に登録する事が出来るアプリです。

●作成理由
私自身、英単語を覚える事にとても苦労していました。英単語の暗記を嫌いにならず、少しでも暗記に役立つアプリを作成したいと思い作成しました。



●使用技術

○開発言語

・Java

〇プロジェクト管理ツール

〇使用フレームワーク
・Java
・css/BootStrap
・MySQL

DB
・MySQL

view

・Thymeleaf,HTML
・css/Bootstrap

○サーバー
・localhost


●実装機能
〇ログアウト時
・辞書機能
・ログイン機能
・新規登録機能

〇ログイン時
・ログアウト機能
・マイページ観覧
・単語帳登録機能
・英単語登録機能
・フラッシュカード機能
・辞書機能
・みんなの単語帳観覧


●SQL文
users(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50) NOT NULL, email VARCHAR(256) NOT NULL UNIQUE, password VARCHAR(256), PRIMARY KEY(id));

vocabulary (id INT AUTO_INCREMENT PRIMARY KEY, book_id INT NOT NULL, word VARCHAR(100) NOT NULL, user_id INT NOT NULL, definition VARCHAR(256) NOT NULL);

addition (id INT AUTO_INCREMENT PRIMARY KEY, added_date DATETIME NOT NULL, user_id INT NOT NULL);

card (id INT AUTO_INCREMENT PRIMARY KEY, good int DEFAULT 0 NOT NULL, bad int DEFAULT 0 NOT NULL, user_id INT NOT NULL);

subscribeBook (id INT AUTO_INCREMENT PRIMARY KEY, user_id INT NOT NULL, book_id INT NOT NULL, subsribe_date DATETIME NOT NULL);

vocabularyBook (id INT AUTO_INCREMENT PRIMARY KEY, created_user_id INT NOT NULL, name VARCHAR(100) NOT NULL, description VARCHAR(256) NOT NULL);
