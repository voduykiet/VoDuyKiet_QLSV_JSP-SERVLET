-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 13, 2021 lúc 04:57 AM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlysinhvien_jsp`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id_account` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_sv` int(11) NOT NULL,
  `role_lecturer` int(11) NOT NULL,
  `role_admin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id_account`, `username`, `password`, `role_sv`, `role_lecturer`, `role_admin`) VALUES
('admin', 'ad', 'ad', 0, 0, 1),
('gv3118410001', 'gv3118410001', '123123', 0, 1, 0),
('gv3118410002', 'gv3118410002', '123123', 0, 1, 0),
('gv311841021123', 'gv311841021123', '123123', 0, 1, 0),
('sv3118410200', 'sv3118410200', '123456', 1, 0, 0),
('sv3118410203', 'sv3118410203', '123456', 1, 0, 0),
('sv3118410205', 'sv3118410205', '123456', 1, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id_category` varchar(255) NOT NULL,
  `name_category` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id_category`, `name_category`) VALUES
('TL01', 'Môn chung'),
('TL03', 'Chương trình nâng cao'),
('TL_2', 'Chuyên ngành\r\n');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `class`
--

CREATE TABLE `class` (
  `id_class` varchar(255) NOT NULL,
  `name_class` varchar(255) NOT NULL,
  `id_specialist` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `class`
--

INSERT INTO `class` (`id_class`, `name_class`, `id_specialist`) VALUES
('CNTT01', 'Công nghệ thông tin 1', 'CNTT'),
('CNTT02', 'Công nghệ thông tin 2', 'CNTT'),
('DTVT01', 'Điện tử viễn thông 1', 'DTVT'),
('DTVT02', 'Điện tử viễn thông 2', 'DTVT'),
('QTKD01', 'Quản trị kinh doanh 1', 'QTKD');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `credit`
--

CREATE TABLE `credit` (
  `id_credit` varchar(255) NOT NULL,
  `number_credit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `credit`
--

INSERT INTO `credit` (`id_credit`, `number_credit`) VALUES
('TC_1', 1),
('TC_2', 2),
('TC_3', 3),
('TC_4', 4),
('TC_5', 5),
('TC_6', 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lecturer`
--

CREATE TABLE `lecturer` (
  `id_lecturer` varchar(255) NOT NULL,
  `name_lecturer` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `lecturer`
--

INSERT INTO `lecturer` (`id_lecturer`, `name_lecturer`, `birthday`, `email`, `phone`, `address`) VALUES
('gv3118410001', 'Nguyễn Loan', '1987-11-11', 'loannguyen@gmail.com', '0978678654', 'Thành Phố HCM'),
('gv3118410002', 'Nguyễn Văn A', '1978-02-03', 'nva@gmail.com', '04234768935', 'Đồng Nai'),
('gv311841021123', 'Nguyễn Thị Thu Loan 1', '2000-11-12', 'voduykiet09112000@gmail.com', '123123123', 'Bình Định');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `school_year`
--

CREATE TABLE `school_year` (
  `id_school_year` varchar(255) NOT NULL,
  `name_school_year` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `school_year`
--

INSERT INTO `school_year` (`id_school_year`, `name_school_year`) VALUES
('NH01', '2016-2017'),
('NH02', '2017-2018'),
('NH03', '2018-2019'),
('Nh04', '2019-2020'),
('NH05', '2020-2021');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `score`
--

CREATE TABLE `score` (
  `id_score` varchar(11) NOT NULL,
  `score_1` float NOT NULL,
  `score_4` float NOT NULL,
  `score_test` float NOT NULL,
  `avg_score` float NOT NULL,
  `id_lecturer` varchar(255) NOT NULL,
  `id_student` varchar(255) NOT NULL,
  `id_subject` varchar(255) NOT NULL,
  `id_credit` varchar(255) NOT NULL,
  `id_category` varchar(255) NOT NULL,
  `id_semester` varchar(255) NOT NULL,
  `id_school_year` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `score`
--

INSERT INTO `score` (`id_score`, `score_1`, `score_4`, `score_test`, `avg_score`, `id_lecturer`, `id_student`, `id_subject`, `id_credit`, `id_category`, `id_semester`, `id_school_year`) VALUES
('MD01', 5, 5, 5, 5, 'gv3118410001', 'sv3118410205', 'MH01', 'TC_3', 'TL_2', 'HK01', 'NH03'),
('MD02', 7, 7, 7, 7, 'gv311841021123', 'sv3118410203', 'MH03', 'TC_3', 'TL01', 'HK01', 'Nh04'),
('MD03', 9, 9, 9, 9, 'gv3118410001', 'sv3118410200', 'MH04', 'TC_3', 'TL_2', 'HK02', 'NH05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `semester`
--

CREATE TABLE `semester` (
  `id_semester` varchar(255) NOT NULL,
  `name_semester` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `semester`
--

INSERT INTO `semester` (`id_semester`, `name_semester`) VALUES
('HK01', 'Học kỳ 1'),
('HK02', 'Học kỳ 2'),
('HK03', 'Học kỳ 3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `specialist`
--

CREATE TABLE `specialist` (
  `id_specialist` varchar(255) NOT NULL,
  `name_specialist` varchar(255) NOT NULL,
  `contact_specialist` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `specialist`
--

INSERT INTO `specialist` (`id_specialist`, `name_specialist`, `contact_specialist`) VALUES
('CNTT', 'Công nghệ thông tin', 'cntt@gmail.com'),
('DTVT', 'Điện tử viễn thông', 'dtvt@gmail.com'),
('GDMN', 'Giáo dục mầm non', 'gdmn@gmail.com'),
('QHQT', 'Quan hệ quốc tế', 'qhqt@gmail.com'),
('QTKD', 'Quản trị kinh doanh', 'qtkd@gmail.com'),
('SPA', 'Sư phạm anh', 'spa@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `id_student` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `id_class` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id_student`, `fullname`, `birthday`, `email`, `phone`, `address`, `id_class`) VALUES
('sv3118410200', 'Võ Kiệt', '2000-12-03', 'vk@gmail.com', '0984638326', 'Phú Yên', 'CNTT01'),
('sv3118410203', 'Nguyễn Phát', '2001-02-14', 'nguyenphat@gmail.com', '07896438896', 'Tân Châu', 'CNTT02'),
('sv3118410205', 'Nguyễn Khang', '2003-02-09', 'khangnguyen@gmail.com', '08932356785', 'Bắc Giang', 'QTKD01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id_subject` varchar(255) NOT NULL,
  `name_subject` varchar(255) NOT NULL,
  `id_credit` varchar(255) NOT NULL,
  `id_category` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`id_subject`, `name_subject`, `id_credit`, `id_category`) VALUES
('MH01', 'Toán rời rạc', 'TC_3', 'TL_2'),
('MH03', 'Xác suất thống kê', 'TC_3', 'TL01'),
('MH04', 'Lập trình Java', 'TC_3', 'TL_2'),
('MH05', 'Tiếng anh', 'TC_3', 'TL01'),
('MH_2', 'Cơ sở dữ liệu', 'TC_3', 'TL_2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject_lecturer`
--

CREATE TABLE `subject_lecturer` (
  `id_subject` varchar(255) NOT NULL,
  `id_lecturer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subject_lecturer`
--

INSERT INTO `subject_lecturer` (`id_subject`, `id_lecturer`) VALUES
('MH_2', 'gv311841021123'),
('MH03', 'gv3118410002'),
('MH04', 'gv311841021123'),
('MH05', 'gv311841021123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id_class`),
  ADD KEY `id_specialist` (`id_specialist`);

--
-- Chỉ mục cho bảng `credit`
--
ALTER TABLE `credit`
  ADD PRIMARY KEY (`id_credit`);

--
-- Chỉ mục cho bảng `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`id_lecturer`);

--
-- Chỉ mục cho bảng `school_year`
--
ALTER TABLE `school_year`
  ADD PRIMARY KEY (`id_school_year`);

--
-- Chỉ mục cho bảng `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id_score`),
  ADD KEY `id_lecturer` (`id_lecturer`),
  ADD KEY `id_student` (`id_student`),
  ADD KEY `id_subject` (`id_subject`),
  ADD KEY `id_credit` (`id_credit`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_semester` (`id_semester`),
  ADD KEY `id_school_year` (`id_school_year`);

--
-- Chỉ mục cho bảng `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`id_semester`);

--
-- Chỉ mục cho bảng `specialist`
--
ALTER TABLE `specialist`
  ADD PRIMARY KEY (`id_specialist`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_student`),
  ADD KEY `id_class` (`id_class`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id_subject`),
  ADD KEY `id_credit` (`id_credit`),
  ADD KEY `id_category` (`id_category`);

--
-- Chỉ mục cho bảng `subject_lecturer`
--
ALTER TABLE `subject_lecturer`
  ADD KEY `id_lecturer` (`id_lecturer`),
  ADD KEY `id_subject` (`id_subject`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`id_specialist`) REFERENCES `specialist` (`id_specialist`);

--
-- Các ràng buộc cho bảng `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `score_ibfk_10` FOREIGN KEY (`id_semester`) REFERENCES `semester` (`id_semester`),
  ADD CONSTRAINT `score_ibfk_11` FOREIGN KEY (`id_school_year`) REFERENCES `school_year` (`id_school_year`),
  ADD CONSTRAINT `score_ibfk_4` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  ADD CONSTRAINT `score_ibfk_5` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`),
  ADD CONSTRAINT `score_ibfk_6` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`),
  ADD CONSTRAINT `score_ibfk_7` FOREIGN KEY (`id_lecturer`) REFERENCES `lecturer` (`id_lecturer`),
  ADD CONSTRAINT `score_ibfk_9` FOREIGN KEY (`id_credit`) REFERENCES `subject` (`id_credit`);

--
-- Các ràng buộc cho bảng `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`id_class`) REFERENCES `class` (`id_class`);

--
-- Các ràng buộc cho bảng `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  ADD CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`id_credit`) REFERENCES `credit` (`id_credit`);

--
-- Các ràng buộc cho bảng `subject_lecturer`
--
ALTER TABLE `subject_lecturer`
  ADD CONSTRAINT `subject_lecturer_ibfk_1` FOREIGN KEY (`id_lecturer`) REFERENCES `lecturer` (`id_lecturer`),
  ADD CONSTRAINT `subject_lecturer_ibfk_2` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id_subject`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
