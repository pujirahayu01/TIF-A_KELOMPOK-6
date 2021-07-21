-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Jul 2021 pada 17.26
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 8.0.2

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
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(6) CHARACTER SET utf8mb4 NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `harga_jual` int(20) NOT NULL,
  `harga_beli` int(20) NOT NULL,
  `stok` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `harga_jual`, `harga_beli`, `stok`) VALUES
('B001', 'BERAS HT 40 KG ', 50000, 480000, 154),
('B002', 'BERAS HT 10 KG', 100000, 98000, 17),
('B003', 'BERAS HT 25Kg', 125000, 123000, 23),
('M001', 'Minyak Bimoli 1 L', 12000, 11000, 33);

-- --------------------------------------------------------

--
-- Struktur dari tabel `dtl_pembelian`
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
-- Dumping data untuk tabel `dtl_pembelian`
--

INSERT INTO `dtl_pembelian` (`no_beli`, `username`, `kode_supplier`, `tot_harga`, `tanggal`, `datetime`) VALUES
('B00001', 'bambang', '1', 4, '2021-07-17', '20:27:02'),
('B00002', 'bambang', '1', 16, '2021-07-17', '20:29:42'),
('B00003', 'bambang', '1', 588005, '2021-07-18', '00:39:46');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dtl_penjualan`
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
-- Dumping data untuk tabel `dtl_penjualan`
--

INSERT INTO `dtl_penjualan` (`no_faktur`, `username`, `tot_harga`, `uang`, `kembalian`, `tanggal`, `datetime`) VALUES
('F00001', 'bambang', 20000, 30000, 10000, '2021-07-04', '16:21:05'),
('F00002', 'bambang', 350000, 400000, 50000, '2021-07-04', '16:27:49'),
('F00003', 'bambang', 250000, 250000, 0, '2021-07-04', '16:50:33'),
('F00004', 'bambang', 675000, 700000, 25000, '2021-07-04', '17:19:48'),
('F00005', 'Surya', 375013, 400000, 24987, '2021-07-04', '17:21:02'),
('F00006', 'bambang', 65, 100, 35, '2021-07-17', '20:22:41'),
('F00007', 'bambang', 130, 150, 20, '2021-07-18', '00:39:26'),
('F00008', 'Surya', 195, 200, 5, '2021-07-18', '00:41:36');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `no_pembelian` int(11) NOT NULL,
  `no_beli` varchar(6) NOT NULL,
  `kode_barang` varchar(6) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tot_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`no_pembelian`, `no_beli`, `kode_barang`, `jumlah`, `tot_harga`) VALUES
(5, 'B00003', 'b002', 6, 588000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjual`
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
-- Dumping data untuk tabel `penjual`
--

INSERT INTO `penjual` (`username`, `nama_depan`, `nama_belakang`, `alamat`, `no_hp`, `password`, `level`) VALUES
('bambang', 'Bambang', 'Supri', 'Jln Anjasmara no 88 Jember', '08765215129', '123', 'admin'),
('rido', 'Rido', 'Hidayah', 'Dusun kresek Ajung', '08351262476', '456', 'user'),
('surya', 'Surya', 'Adi', 'Desa Durian Runtuh no 12', '0898879087', '789', 'user');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `no_penjualan` int(11) NOT NULL,
  `no_faktur` varchar(6) NOT NULL,
  `kode_barang` varchar(6) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tot_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`no_penjualan`, `no_faktur`, `kode_barang`, `jumlah`, `tot_harga`) VALUES
(25, 'F00003', 'b003', 2, 250000),
(26, 'F00004', 'B002', 3, 300000),
(27, 'F00004', 'B003', 3, 375000),
(28, 'F00005', 'B003', 3, 375000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(20) NOT NULL,
  `namaSPL_depan` varchar(35) NOT NULL,
  `namaSPL_blk` varchar(35) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `namaSPL_depan`, `namaSPL_blk`, `Alamat`, `no_hp`) VALUES
('1', 'Adam', 'Hasbullah', 'Jln Ototista no 125 Banyuwangi', '086987890989'),
('2', 'Riyan', 'Hariyadi', 'Jln Kenanga no 34 Jember', '082147483647');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `dtl_pembelian`
--
ALTER TABLE `dtl_pembelian`
  ADD PRIMARY KEY (`no_beli`),
  ADD KEY `kode_supplier` (`kode_supplier`),
  ADD KEY `username` (`username`);

--
-- Indeks untuk tabel `dtl_penjualan`
--
ALTER TABLE `dtl_penjualan`
  ADD PRIMARY KEY (`no_faktur`),
  ADD KEY `username` (`username`);

--
-- Indeks untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`no_pembelian`),
  ADD KEY `no_beli` (`no_beli`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indeks untuk tabel `penjual`
--
ALTER TABLE `penjual`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_penjualan`),
  ADD KEY `no_faktur` (`no_faktur`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `no_pembelian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `no_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `dtl_pembelian`
--
ALTER TABLE `dtl_pembelian`
  ADD CONSTRAINT `dtl_pembelian_ibfk_1` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`),
  ADD CONSTRAINT `dtl_pembelian_ibfk_2` FOREIGN KEY (`username`) REFERENCES `penjual` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `dtl_penjualan`
--
ALTER TABLE `dtl_penjualan`
  ADD CONSTRAINT `dtl_penjualan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `penjual` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`no_beli`) REFERENCES `dtl_pembelian` (`no_beli`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`no_faktur`) REFERENCES `dtl_penjualan` (`no_faktur`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
