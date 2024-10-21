-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-10-2024 a las 21:14:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recipenest`
--
CREATE DATABASE IF NOT EXISTS `recipenest` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `recipenest`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_ingredients`
--

CREATE TABLE `dbo_ingredients` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_recipes`
--

CREATE TABLE `dbo_recipes` (
  `id` bigint(20) NOT NULL,
  `description` longtext DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_recipe_ingredients`
--

CREATE TABLE `dbo_recipe_ingredients` (
  `id` bigint(20) NOT NULL,
  `quantity` varchar(255) NOT NULL,
  `ingredient_id` bigint(20) NOT NULL,
  `recipe_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dbo_users`
--

CREATE TABLE `dbo_users` (
  `id_user` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dbo_users`
--

INSERT INTO `dbo_users` (`id_user`, `name`, `password`, `role`, `username`) VALUES
(1, 'Eliezer Navarro', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'enp'),
(2, 'Rayme Velandia', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'raymevg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dbo_ingredients`
--
ALTER TABLE `dbo_ingredients`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `dbo_recipes`
--
ALTER TABLE `dbo_recipes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK41h8ish3ygejaqwylu468to80` (`user_id`);

--
-- Indices de la tabla `dbo_recipe_ingredients`
--
ALTER TABLE `dbo_recipe_ingredients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkf699q8grpbwhh9dy2nk4i46e` (`ingredient_id`),
  ADD KEY `FKp273we2eitsx2aj9e7xhmuhtn` (`recipe_id`);

--
-- Indices de la tabla `dbo_users`
--
ALTER TABLE `dbo_users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dbo_ingredients`
--
ALTER TABLE `dbo_ingredients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_recipes`
--
ALTER TABLE `dbo_recipes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_recipe_ingredients`
--
ALTER TABLE `dbo_recipe_ingredients`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dbo_users`
--
ALTER TABLE `dbo_users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dbo_recipes`
--
ALTER TABLE `dbo_recipes`
  ADD CONSTRAINT `FK41h8ish3ygejaqwylu468to80` FOREIGN KEY (`user_id`) REFERENCES `dbo_users` (`id_user`);

--
-- Filtros para la tabla `dbo_recipe_ingredients`
--
ALTER TABLE `dbo_recipe_ingredients`
  ADD CONSTRAINT `FKkf699q8grpbwhh9dy2nk4i46e` FOREIGN KEY (`ingredient_id`) REFERENCES `dbo_ingredients` (`id`),
  ADD CONSTRAINT `FKp273we2eitsx2aj9e7xhmuhtn` FOREIGN KEY (`recipe_id`) REFERENCES `dbo_recipes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
