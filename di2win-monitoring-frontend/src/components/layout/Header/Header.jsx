import React from 'react';
import styles from './Header.module.css';
import logo from '../../../assets/images/LOGO.svg';

const Header = () => {
  return (
    <header className={styles.header}>
      <img src={logo} alt="Logo Di2win" className={styles.logo} />
    </header>
  );
};

export default Header;

