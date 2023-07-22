const products = [
  {
    name: "One Pice",
    category: "Anime",
    price: 10.99,
    quantity: 20,
    description:
      '"One Piece" là một cuộc phiêu lưu tuyệt vời, nơi những giấc mơ và trái tim can đảm gặp gỡ. Câu chuyện xoay quanh Monkey D. Luffy, một cậu bé tươi sáng và tinh nghịch, khao khát trở thành Vua Hải Tặc. Với sức mạnh kỳ diệu từ trái ác quỷ Gomu Gomu, Luffy dẫn đầu nhóm Mũ Rơm, một băng hải tặc đầy màu sắc và độc đáo.\n' +
      "Trên hành trình đến Grand Line, vùng biển nguy hiểm và bí ẩn, Luffy và đồng đội của mình đối mặt với những thử thách khó khăn và đối đầu với những kẻ thù mạnh mẽ. Tuy nhiên, trong cuộc phiêu lưu đầy máu lửa và tiếng cười, họ cũng gặp gỡ những người bạn đồng hành và xây dựng mối quan hệ đáng quý. Cùng nhau, nhóm Mũ Rơm tìm kiếm kho báu One Piece, niềm hy vọng cuối cùng để đạt được ước mơ và trở thành Vua Hải Tặc.\n" +
      '"One Piece" không chỉ là một câu chuyện về hành trình tìm kiếm kho báu, mà còn là một tác phẩm về tình bạn, lòng dũng cảm và khát vọng tự do. Với vũ trụ rộng lớn và những nhân vật đa dạng, bộ anime và manga này đã gây tiếng vang toàn cầu và thu hút hàng triệu người hâm mộ trên khắp thế giới. "One Piece" là một cuộc phiêu lưu không thể bỏ qua, nơi mọi người có thể tìm thấy niềm vui, cảm xúc và thông điệp sâu sắc về mục tiêu và giá trị của cuộc sống.',
    imageURL:
      "https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218618/PorterAnime/porter_ONE.PIECE_afwg7z.jpg",
    user_username: "admin",
  },
  {
    name: "Youkoso Jitsuryoku Shijou Shugi no Kyoushitsu e",
    category: "School",
    price: 19.99,
    quantity: 15,
    description:
      '"Youkoso Jitsuryoku Shijou Shugi no Kyoushitsu e", còn được gọi là "Classroom of the Elite", là một bộ anime và light novel Nhật Bản. Được viết bởi Shōgo Kinugasa và minh họa bởi Shunsaku Tomose, câu chuyện xoay quanh một trường học đặc biệt có tên là Koudo Ikusei.\n' +
      "Trường Koudo Ikusei không chỉ tập trung vào việc giảng dạy kiến thức mà còn đánh giá học sinh dựa trên thành tích xã hội và khả năng thể chất. Học sinh ở đây được đánh giá bằng điểm, và học sinh có điểm cao được đặc quyền và đề cử tham gia vào lớp A, lớp ưu tú nhất của trường.\n" +
      "Câu chuyện xoay quanh Kiyotaka Ayanokouji, một học sinh mới nhập học và chuyển vào lớp D - lớp thấp nhất của trường. Mặc dù có ngoại hình bình thường và vẻ ngoài ít nói, Kiyotaka sở hữu khả năng phân tích và suy luận xuất sắc. Cùng với hai bạn cùng lớp là Suzune Horikita và Kikyou Kushida, Kiyotaka bắt đầu khám phá sự thật đằng sau hệ thống giáo dục của trường và tham gia vào các cuộc thử thách và tranh đua đầy cạnh tranh trong môi trường học tập đầy áp lực.\n" +
      '"Youkoso Jitsuryoku Shijou Shugi no Kyoushitsu e" mang đến một câu chuyện hấp dẫn về sự cạnh tranh và tâm lý con người trong một môi trường giáo dục đặc biệt. Đây là một bộ anime và light novel pha trộn giữa yếu tố hành động, bí ẩn và drama, đưa người xem vào những cuộc chiến tư duy và cạnh tranh khốc liệt giữa những tài năng trẻ.',
    imageURL:
      "https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218622/PorterAnime/porter_Youkoso.Jitsuryoku.Shijou.Shugi.no.Kyoushitsu.e_vhu2gn.jpg",
    user_username: "admin",
  },
  {
    name: "OverLord",
    category: "adventure",
    price: 7.5,
    quantity: 30,
    description:
      '"Overlord" là một bộ anime và light novel Nhật Bản, được viết bởi Kugane Maruyama và minh họa bởi so-bin. Câu chuyện xoay quanh một game trực tuyến thế giới ảo gọi là Yggdrasil, nơi người chơi có thể sống trong vai trò của nhân vật trong game.\n' +
      "Nhưng khi game Yggdrasil bước vào giai đoạn tắt máy cuối cùng, Momonga, một người chơi lão luyện, quyết định ở lại trong thế giới game cho đến khi nó chính thức tắt. Tuy nhiên, Momonga bất ngờ phát hiện rằng thế giới ảo Yggdrasil đã không tắt đi và trở thành một thế giới thực sự, với nhân vật và cảnh quan sống động.\n" +
      'Để khám phá sức mạnh của mình trong thế giới mới này, Momonga, giờ đây là Ainz Ooal Gown - một lâu đài bất tử và tối thượng, quyết định trở thành "Overlord" và lãnh đạo lực lượng quân sự của mình gọi là Áo Đen. Cùng với các tướng lĩnh mạnh mẽ và tài năng, Ainz Ooal Gown bước vào một cuộc phiêu lưu đầy hành động, chiến đấu và cạnh tranh trong thế giới mới này.\n' +
      '"Overlord" mang đến cho khán giả một câu chuyện về thế giới ảo chuyển thành thực tại và sự thích nghi của nhân vật chính trong môi trường mới. Với yếu tố hành động, phép thuật và yếu tố RPG, bộ anime và light novel này mang đến những trận chiến độc đáo và câu chuyện tình cảm phức tạp giữa nhân vật và thế giới xung quanh.',
    imageURL:
      "https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218618/PorterAnime/porter_Overlord_ebng2t.jpg",
    user_username: "admin",
  },
  {
    name: "Haikyuu",
    category: "Sport",
    price: 5.99,
    quantity: 25,
    description:
      '"Haikyuu!!" là một bộ anime và manga nổi tiếng của Nhật Bản, được sáng tác bởi Haruichi Furudate. Bộ truyện kể về cuộc hành trình của một đội bóng chuyền trường trung học và những nỗ lực của các thành viên để vươn lên trở thành những ngôi sao trong môn thể thao này.\n' +
      'Câu chuyện xoay quanh Hinata Shoyo, một cậu học sinh trung học nhỏ bé nhưng đam mê bóng chuyền. Mặ despite being short in stature, he possesses incredible jumping power and a burning passion for the sport. Với ước mơ trở thành một người chơi vĩ đại, Hinata tham gia vào đội bóng chuyền trường Karasuno. Tại đây, anh gặp đối thủ của mình - Kageyama Tobio, một cầu thủ giỏi với tên gọi "Vua Sát Thủ".\n' +
      "Dù bị chia cắt bởi quá khứ và cá nhân, Hinata và Kageyama nhanh chóng nhận ra rằng họ cần phải hợp tác để đạt được thành công. Cùng với các thành viên khác của đội bóng Karasuno, họ hình thành một đội hình đồng đều và bắt đầu tham gia vào các trận đấu gay cấn và khốc liệt.\n" +
      '"Haikyuu!!" không chỉ là một bộ anime và manga về bóng chuyền, mà còn là một câu chuyện về tình bạn, sự đồng lòng và phát triển cá nhân. Từ các trận đấu kịch tính cho đến những thử thách và phát triển cá nhân của mỗi nhân vật, bộ truyện này mang đến cho người xem sự cảm nhận về sự cống hiến và niềm đam mê trong cuộc sống và thể thao.',
    imageURL:
      "https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218617/PorterAnime/porter_Haikyuu_mnvn34.jpg",
    user_username: "admin",
  },
  {
    name: "Death Note",
    category: "detective",
    price: 12.49,
    quantity: 10,
    description:
      '"Death Note" là một bộ anime và manga nổi tiếng của Nhật Bản, được sáng tác bởi Tsugumi Ohba và minh họa bởi Takeshi Obata. Câu chuyện xoay quanh một cuốn sổ gọi là "Death Note" có khả năng giết người mà bất kỳ ai viết tên của một người vào đó.\n' +
      "Chính Kira, tên được người sở hữu cuốn sổ tự gọi, trở thành một nhân vật truyền cảm hứng và cũng gây sợ hãi trong cộng đồng tội phạm. Kira, tức Yagami Light, là một học sinh cực kỳ thông minh và quyết định sử dụng Death Note để tiêu diệt tất cả tội phạm trên thế giới. Anh ta tin rằng việc này sẽ mang lại sự công lý tuyệt đối và tạo ra một thế giới hoàn hảo.\n" +
      "Tuy nhiên, mọi thứ trở nên phức tạp khi một thám tử tài ba tên là L bắt đầu săn lùng Kira. Một cuộc đối đầu căng thẳng và trí tuệ bắt đầu giữa hai tâm trí siêu việt, mỗi người đều muốn chiến thắng và thi hành sự công lý theo cách riêng.\n" +
      '"Death Note" không chỉ là một câu chuyện về tội phạm và truy sát, mà còn đặt ra những câu hỏi đạo đức và triết lý về quyền phán xử và quyền sống còn. Bộ anime và manga này khám phá sâu sắc về tâm lý con người, quyền lực và hậu quả của việc sử dụng quyền lực đối với cá nhân và xã hội.',
    imageURL:
      "https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218617/PorterAnime/porter_Death_Note_awtvkz.jpg",
    user_username: "admin",
  },
];

module.exports = products;
