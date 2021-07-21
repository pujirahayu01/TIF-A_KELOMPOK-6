-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2021 at 08:35 PM
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
('B001', 'BERAS HT 40 KG ', 50000, 480000, 45),
('B002', 'BERAS HT 10 KG', 100000, 98000, 32),
('B003', 'BERAS HT 25Kg', 125000, 123000, 38),
('B004', 'BERAS MAKNYUSS 10 KG', 149500, 130000, 23),
('M001', 'Minyak Bimoli 1 L', 12000, 11000, 31),
('S001', 'Pensil 2B', 1725, 1500, 16),
('s002', 'Bulpoin Pilot', 1955, 1700, 8);

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
('B00001', 'bambang', '1', 4, '2021-07-17', '20:27:02'),
('B00002', 'bambang', '1', 16, '2021-07-17', '20:29:42'),
('B00003', 'bambang', '1', 588005, '2021-07-18', '00:39:46'),
('B00004', 'Bambang', 's001', 4690000, '2021-07-21', '23:36:18'),
('B00005', 'Bambang', '1', 1156000, '2021-07-22', '00:47:54'),
('B00006', 'Bambang', '1', 811000, '2021-07-22', '00:49:12'),
('B00007', 'Bambang', 's001', 1043400, '2021-07-22', '01:26:26');

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
('F00001', 'bambang', 20000, 30000, 10000, '2021-07-04', '16:21:05'),
('F00002', 'bambang', 350000, 400000, 50000, '2021-07-04', '16:27:49'),
('F00003', 'bambang', 250000, 250000, 0, '2021-07-04', '16:50:33'),
('F00004', 'bambang', 675000, 700000, 25000, '2021-07-04', '17:19:48'),
('F00005', 'Surya', 375013, 400000, 24987, '2021-07-04', '17:21:02'),
('F00006', 'bambang', 65, 100, 35, '2021-07-17', '20:22:41'),
('F00007', 'bambang', 130, 150, 20, '2021-07-18', '00:39:26'),
('F00008', 'Surya', 195, 200, 5, '2021-07-18', '00:41:36'),
('F00009', 'Bambang', 460500, 500000, 39500, '2021-07-22', '01:22:56'),
('F00010', 'Bambang', 472500, 500000, 27500, '2021-07-22', '01:24:09'),
('F00011', 'Bambang', 14720, 15000, 280, '2021-07-22', '01:30:42');

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
(5, 'B00003', 'b002', 6, 588000),
(6, 'B00004', 'b001', 3, 1440000),
(7, 'B00004', 'B004', 25, 3250000),
(8, 'B00005', 'b001', 2, 960000),
(9, 'B00005', 'b002', 2, 196000),
(10, 'B00006', 'b002', 2, 196000),
(11, 'B00006', 'b003', 5, 615000),
(12, 'B00007', 'S001', 20, 30000),
(13, 'B00007', 's002', 12, 20400),
(14, 'B00007', 'b001', 2, 960000),
(15, 'B00007', 'm001', 3, 33000);

-- --------------------------------------------------------

--
-- Table structure for table `penjual`
--

CREATE TABLE `penjual` (
  `username` varchar(20) NOT NULL,
  `nama_depan` varchar(35) NOT NULL,
  `nama_belakang` varchar(30) NOT NULL,
  `alamat` varchar(35) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `password` varchar(11) NOT NULL,
  `level` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjual`
--

INSERT INTO `penjual` (`username`, `nama_depan`, `nama_belakang`, `alamat`, `no_hp`, `password`, `level`) VALUES
('bambang', 'Bambang', 'Supri', 'Jln Anjasmara no 88 Jember', '08765215129', '123', 'admin'),
('rido', 'Rido', 'Hidayah', 'Dusun kresek Ajung', '08351262476', '456', 'user'),
('surya', 'Surya', 'Adi', 'Desa Durian Runtuh no 12', '0898879087', '789', 'user');

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
(25, 'F00003', 'b003', 2, 250000),
(26, 'F00004', 'B002', 3, 300000),
(27, 'F00004', 'B003', 3, 375000),
(28, 'F00005', 'B003', 3, 375000),
(34, 'F00009', 'M001', 3, 36000),
(35, 'F00009', 'B004', 1, 149500),
(36, 'F00009', 'B003', 1, 125000),
(37, 'F00009', 'B002', 1, 100000),
(38, 'F00009', 'B001', 1, 50000),
(39, 'F00010', 'B001', 1, 50000),
(40, 'F00010', 'B002', 1, 100000),
(41, 'F00010', 'B003', 1, 125000),
(42, 'F00010', 'B004', 1, 149500),
(43, 'F00010', 'M001', 4, 48000),
(44, 'F00011', 'S001', 4, 6900),
(45, 'F00011', 's002', 4, 7820);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(20) NOT NULL,
  `namaSPL_depan` varchar(35) NOT NULL,
  `namaSPL_blk` varchar(35) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `namaSPL_depan`, `namaSPL_blk`, `Alamat`, `no_hp`) VALUES
('1', 'Adam', 'Hasbullah', 'Jln Ototista no 125 Banyuwangi', '086987890989'),
('2', 'Riyan', 'Hariyadi', 'Jln Kenanga no 34 Jember', '082147483647'),
('S001', 'PT', 'JAYA MAKMUR', 'Jl. Kaliurang no. 7a', '081333215542');

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
  MODIFY `no_pembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `no_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

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
