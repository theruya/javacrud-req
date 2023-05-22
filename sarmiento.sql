-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2023 at 10:43 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sarmiento`
--

-- --------------------------------------------------------

--
-- Table structure for table `player_tbl`
--

CREATE TABLE `player_tbl` (
  `id` int(11) NOT NULL,
  `pname` varchar(250) NOT NULL,
  `ptag` varchar(250) NOT NULL,
  `prank` varchar(250) NOT NULL,
  `pmrole` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `player_tbl`
--

INSERT INTO `player_tbl` (`id`, `pname`, `ptag`, `prank`, `pmrole`) VALUES
(5, 'jolleihotdog', 'kth1', 'Radiant', 'Initiator'),
(6, 'kaym', '1727', 'Diamond 1', 'Controller'),
(7, 'ruya', 'wvte', 'Gold 3', 'Initiator'),
(8, 'lalalacarmela', 'ace', 'Platinum 1', 'Duelist'),
(9, 'bisky', 'aly', 'Gold 2', 'Sentinel'),
(10, 'Sample', 'ng mama mo', 'Ascendant 2', 'Duelist'),
(11, 'HYTASS', 'tass', 'Ascendant 3', 'Duelist'),
(12, 'cosmos', 'pjs', 'Gold 1', 'Controller');

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `id` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `player_tbl`
--
ALTER TABLE `player_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `player_tbl`
--
ALTER TABLE `player_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user_tbl`
--
ALTER TABLE `user_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
