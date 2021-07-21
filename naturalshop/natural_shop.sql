-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2021 at 02:19 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `natural_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(6) CHARACTER SET utf8mb4 NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `harga_jual` int(20) NOT NULL,
  `harga_beli` int(20) NOT NULL,
  `stok` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `harga_jual`, `harga_beli`, `stok`) VALUES
('1', '12', 13, 1, 39),
('B001', 'BERAS HT 40 KG ', 50000, 480000, 15),
('B002', 'BERAS HT 10 KG', 100000, 98000, 28),
('B003', 'BERAS HT 25Kg', 125000, 123000, 124995),
('G001', 'Gula ', 9000, 8000, 45),
('M001', 'Minyak Bimoli 1 L', 12000, 11000, 35965),
('n001', 'Sania', 23000, 20000, 8),
('n002', 'BERAS HT 40 KG ', 21850, 19000, 3),
('n003', 'bimoli', 17250, 15000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `dtl_pembelian`
--

CREATE TABLE `dtl_pembelian` (
  `no_beli` varchar(6) NOT NULL,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `kode_supplier` varchar(20) CHARACTER SET latin1 NOT NULL,
  `tot_harga` int(9) NOT NULL,
  `tanggal` date NOT NULL,
  `datetime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dtl_pembelian`
--

INSERT INTO `dtl_pembelian` (`no_beli`, `username`, `kode_supplier`, `tot_harga`, `tanggal`, `datetime`) VALUES
('B00001', 'bambang', '1', 400182, '2021-07-18', '14:54:02'),
('B00002', 'bambang', '1', 2000000, '2021-07-19', '20:43:05'),
('B00003', 'bambang', '1', 1450000, '2021-07-19', '20:46:25'),
('B00004', 'bambang', '1', 600000, '2021-07-19', '20:49:05'),
('B00005', 'bambang', '1', 150000, '2021-07-19', '20:51:35'),
('B00006', 'bambang', '1', 750000, '2021-07-19', '20:52:02'),
('B00007', 'bambang', '1', 300000, '2021-07-19', '20:53:04'),
('B00008', 'bambang', '1', 1300000, '2021-07-19', '20:53:22'),
('B00009', 'bambang', '1', 2410000, '2021-07-20', '20:52:28'),
('B00010', 'bambang', '1', 2988000, '2021-07-20', '21:19:01'),
('B00011', 'bambang', '1', 2410000, '2021-07-20', '21:21:02'),
('B00012', 'bambang', '1', 1980000, '2021-07-20', '21:30:31'),
('B00013', 'bambang', '1', 2671000, '2021-07-20', '21:43:00'),
('B00014', 'bambang', '1', 3198000, '2021-07-20', '21:43:42'),
('B00015', 'bambang', '1', 3063000, '2021-07-20', '21:54:35'),
('B00016', 'bambang', '1', 2460000, '2021-07-20', '21:56:20'),
('B00017', 'bambang', '1', 2937000, '2021-07-20', '21:59:59'),
('B00018', 'bambang', '1', 1500000, '2021-07-20', '22:05:56'),
('B00019', 'bambang', '1', 1500000, '2021-07-20', '22:07:25'),
('B00020', 'bambang', '1', 3420000, '2021-07-20', '22:26:38');

-- --------------------------------------------------------

--
-- Table structure for table `dtl_penjualan`
--

CREATE TABLE `dtl_penjualan` (
  `no_faktur` varchar(6) NOT NULL,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `tot_harga` int(9) NOT NULL,
  `uang` int(9) NOT NULL,
  `kembalian` int(9) NOT NULL,
  `tanggal` date NOT NULL,
  `datetime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dtl_penjualan`
--

INSERT INTO `dtl_penjualan` (`no_faktur`, `username`, `tot_harga`, `uang`, `kembalian`, `tanggal`, `datetime`) VALUES
('F00005', 'Surya', 375013, 400000, 24987, '2021-07-04', '17:21:02'),
('F00008', 'Surya', 195, 200, 5, '2021-07-18', '00:41:36'),
('F00009', 'bambang', 700065, 750000, 49935, '2021-07-18', '15:42:43'),
('F00010', 'bambang', 1023195, 1050000, 26805, '2021-07-18', '15:52:10'),
('F00011', 'bambang', 13, 20, 7, '2021-07-18', '15:52:22'),
('F00012', 'bambang', 400000, 400000, 0, '2021-07-18', '16:14:54'),
('F00013', 'bambang', 536065, 550000, 13935, '2021-07-18', '16:31:51'),
('F00014', 'bambang', 225000, 250000, 25000, '2021-07-18', '16:33:40'),
('F00015', 'bambang', 286000, 300000, 14000, '2021-07-19', '11:38:23'),
('F00016', 'bambang', 274000, 300000, 26000, '2021-07-19', '12:20:58'),
('F00017', 'bambang', 550000, 550000, 0, '2021-07-19', '20:12:13'),
('F00018', 'bambang', 400039, 450000, 49961, '2021-07-19', '20:33:21'),
('F00019', 'bambang', 650000, 650000, 0, '2021-07-20', '20:37:05'),
('F00020', 'bambang', 300000, 300000, 0, '2021-07-20', '20:39:44'),
('F01999', 'bambang', 225000, 250000, 25000, '2021-07-21', '01:46:48');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `no_pembelian` int(11) NOT NULL,
  `no_beli` varchar(6) NOT NULL,
  `kode_barang` varchar(6) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tot_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`no_pembelian`, `no_beli`, `kode_barang`, `jumlah`, `tot_harga`) VALUES
(8, 'B00001', '1', 14, 182),
(9, 'B00001', 'B002', 4, 400000),
(10, 'B00002', 'B001', 20, 1000000),
(11, 'B00002', 'B002', 10, 1000000),
(12, 'B00003', 'B001', 5, 250000),
(13, 'B00003', 'B002', 12, 1200000),
(14, 'B00004', 'B001', 12, 600000),
(15, 'B00005', 'B001', 3, 150000),
(16, 'B00006', 'B001', 15, 750000),
(17, 'B00007', 'B001', 6, 300000),
(18, 'B00008', 'B002', 13, 1300000),
(19, 'B00009', 'B001', 4, 1920000),
(20, 'B00009', 'B002', 5, 490000),
(21, 'B00010', 'B001', 480000, 50000),
(22, 'B00010', 'B002', 98000, 100000),
(23, 'B00011', 'B001', 4, 1920000),
(24, 'B00011', 'B002', 5, 490000),
(25, 'B00012', 'B001', 4, 1920000),
(27, 'B00013', 'B001', 5, 2400000),
(28, 'B00013', 'B002', 2, 196000),
(29, 'B00014', 'B001', 5, 2400000),
(30, 'B00014', 'B003', 6, 738000),
(31, 'B00016', 'B001', 5, 2400000),
(32, 'B00017', 'B001', 6, 2880000),
(33, 'B00017', 'n002', 3, 57000),
(34, 'B00018', 'B001', 3, 1440000),
(35, 'B00019', 'B001', 3, 1440000),
(36, 'B00019', 'n001', 3, 60000),
(37, 'B00020', 'b001', 7, 3360000),
(38, 'B00020', 'n003', 4, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `penjual`
--

CREATE TABLE `penjual` (
  `username` varchar(20) NOT NULL,
  `nama_depan` varchar(35) NOT NULL,
  `nama_belakang` varchar(30) NOT NULL,
  `alamat` varchar(11) NOT NULL,
  `no_hp` int(15) NOT NULL,
  `password` varchar(11) NOT NULL,
  `level` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjual`
--

INSERT INTO `penjual` (`username`, `nama_depan`, `nama_belakang`, `alamat`, `no_hp`, `password`, `level`) VALUES
('bambang', 'bambang', 'cahyono', 'lul', 8232, '123', 'admin'),
('pentol', '1212', '1212', '1212', 1212, '123', 'user'),
('surya', 'Surya', 'Adi', 'leces3', 1212, '1', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_penjualan` int(11) NOT NULL,
  `no_faktur` varchar(6) NOT NULL,
  `kode_barang` varchar(6) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tot_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`no_penjualan`, `no_faktur`, `kode_barang`, `jumlah`, `tot_harga`) VALUES
(28, 'F00005', 'B003', 3, 375000),
(41, 'F00009', '1', 5, 65),
(42, 'F00009', 'B002', 7, 700000),
(43, 'F00010', '1', 15, 195),
(44, 'F00010', 'B001', 2, 100000),
(45, 'F00010', 'B002', 5, 500000),
(46, 'F00010', 'B003', 3, 375000),
(47, 'F00010', 'M001', 4, 48000),
(48, 'F00011', '1', 1, 13),
(51, 'F00012', 'B001', 2, 100000),
(52, 'F00012', 'B002', 3, 300000),
(53, 'F00013', '1', 5, 65),
(54, 'F00013', 'B003', 4, 500000),
(55, 'F00013', 'M001', 3, 36000),
(56, 'F00014', 'B001', 2, 100000),
(57, 'F00014', 'B003', 1, 125000),
(58, 'F00015', 'M001', 3, 36000),
(59, 'F00015', 'B003', 2, 250000),
(60, 'F00016', 'B001', 5, 250000),
(61, 'F00016', 'M001', 2, 24000),
(62, 'F00017', 'B001', 3, 150000),
(63, 'F00017', 'B002', 4, 400000),
(64, 'F00018', '1', 3, 39),
(65, 'F00018', 'B002', 4, 400000),
(66, 'F00019', 'B001', 3, 150000),
(69, 'F00020', 'B001', 2, 100000),
(70, 'F00020', 'B002', 2, 200000),
(73, 'F01999', 'B001', 2, 100000),
(74, 'F01999', 'B003', 1, 125000);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(20) NOT NULL,
  `namaSPL_depan` varchar(35) NOT NULL,
  `namaSPL_blk` varchar(35) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `no_hp` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `namaSPL_depan`, `namaSPL_blk`, `Alamat`, `no_hp`) VALUES
('1', 'pentol', 'aci', '', 123),
('etetetetet', 'etet', 'etet323', 'etet', 213123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `dtl_pembelian`
--
ALTER TABLE `dtl_pembelian`
  ADD PRIMARY KEY (`no_beli`),
  ADD KEY `kode_supplier` (`kode_supplier`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `dtl_penjualan`
--
ALTER TABLE `dtl_penjualan`
  ADD PRIMARY KEY (`no_faktur`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`no_pembelian`),
  ADD KEY `no_beli` (`no_beli`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `penjual`
--
ALTER TABLE `penjual`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_penjualan`),
  ADD KEY `no_faktur` (`no_faktur`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `no_pembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `no_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dtl_pembelian`
--
ALTER TABLE `dtl_pembelian`
  ADD CONSTRAINT `dtl_pembelian_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`),
  ADD CONSTRAINT `dtl_pembelian_ibfk_2` FOREIGN KEY (`username`) REFERENCES `penjual` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dtl_penjualan`
--
ALTER TABLE `dtl_penjualan`
  ADD CONSTRAINT `dtl_penjualan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `penjual` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`no_beli`) REFERENCES `dtl_pembelian` (`no_beli`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`no_faktur`) REFERENCES `dtl_penjualan` (`no_faktur`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
