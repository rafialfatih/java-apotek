-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2021 at 11:25 AM
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
-- Database: `dbapotik`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbkategoribarang`
--

CREATE TABLE `tbkategoribarang` (
  `idkategori` int(10) NOT NULL,
  `kategori` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `tbkategoribarang`
--

INSERT INTO `tbkategoribarang` (`idkategori`, `kategori`) VALUES
(1, 'Obat Luar'),
(2, 'Obat Dalam'),
(3, 'Tablet'),
(4, 'Salep'),
(5, 'Syrup');

-- --------------------------------------------------------

--
-- Table structure for table `tblogin`
--

CREATE TABLE `tblogin` (
  `iduser` char(5) COLLATE utf8mb4_bin NOT NULL,
  `namauser` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `jabatan` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `tblogin`
--

INSERT INTO `tblogin` (`iduser`, `namauser`, `password`, `jabatan`) VALUES
('U001', 'Rapuu', 'A30539711BADB1099DC5DB24C63CADC2', 'Admin'),
('U002', 'Rappy', 'E31C5A0181A5E1FE184484D900CC7811', 'Kasir'),
('U003', 'Rafi Alfatih', '3CBB5A586315FE4324DD74FFE862DF97', 'Kasir');

-- --------------------------------------------------------

--
-- Table structure for table `tblokasi`
--

CREATE TABLE `tblokasi` (
  `kodelokasi` int(10) NOT NULL,
  `lokasi` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `tblokasi`
--

INSERT INTO `tblokasi` (`kodelokasi`, `lokasi`) VALUES
(1, 'Rak I'),
(2, 'Rak II'),
(3, 'Etalase'),
(4, 'Kulkas');

-- --------------------------------------------------------

--
-- Table structure for table `tbobat`
--

CREATE TABLE `tbobat` (
  `kodeobat` char(10) COLLATE utf8mb4_bin NOT NULL,
  `namaobat` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `hargabeli` int(10) DEFAULT NULL,
  `satuan` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `harga1` int(10) DEFAULT NULL,
  `harga2` int(10) DEFAULT NULL,
  `stok` int(10) DEFAULT NULL,
  `namakategori` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `lokasi` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `tbobat`
--

INSERT INTO `tbobat` (`kodeobat`, `namaobat`, `hargabeli`, `satuan`, `harga1`, `harga2`, `stok`, `namakategori`, `lokasi`) VALUES
('B001', 'Panadol', 3000, 'Pack', 3000, 3500, 50, 'Obat Dalam', 'Etalase'),
('B002', 'Bodrex', 4000, 'Pack', 5000, 6000, 60, 'Obat Dalam', 'Rak II'),
('B003', 'Tarmadol', 2500, 'Pack', 3000, 3500, 30, 'Obat Luar', 'Rak I'),
('B004', 'Paramex', 3500, 'Pack', 5000, 5500, 250, 'Obat Luar', 'Rak II'),
('B005', 'Panagon', 2500, 'Pack', 5000, 6000, 20, 'Tablet', 'Rak I'),
('B006', 'Bodrexin', 3000, 'Pcs', 6000, 7000, 50, 'Tablet', 'Rak I'),
('B007', 'Mylanta', 5000, 'Pcs', 7000, 8000, 100, 'Obat Dalam', 'Etalase'),
('B008', 'Mixagrip', 8000, 'Pouch', 10000, 12000, 40, 'Obat Dalam', 'Rak II');

-- --------------------------------------------------------

--
-- Table structure for table `tbsatuan`
--

CREATE TABLE `tbsatuan` (
  `kodesatuan` int(10) NOT NULL,
  `satuan` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `tbsatuan`
--

INSERT INTO `tbsatuan` (`kodesatuan`, `satuan`) VALUES
(1, 'Pcs'),
(2, 'Pack'),
(3, 'Dus'),
(4, 'Pouch');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbkategoribarang`
--
ALTER TABLE `tbkategoribarang`
  ADD PRIMARY KEY (`idkategori`);

--
-- Indexes for table `tblogin`
--
ALTER TABLE `tblogin`
  ADD PRIMARY KEY (`iduser`);

--
-- Indexes for table `tblokasi`
--
ALTER TABLE `tblokasi`
  ADD PRIMARY KEY (`kodelokasi`);

--
-- Indexes for table `tbobat`
--
ALTER TABLE `tbobat`
  ADD PRIMARY KEY (`kodeobat`);

--
-- Indexes for table `tbsatuan`
--
ALTER TABLE `tbsatuan`
  ADD PRIMARY KEY (`kodesatuan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbkategoribarang`
--
ALTER TABLE `tbkategoribarang`
  MODIFY `idkategori` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tblokasi`
--
ALTER TABLE `tblokasi`
  MODIFY `kodelokasi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbsatuan`
--
ALTER TABLE `tbsatuan`
  MODIFY `kodesatuan` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
