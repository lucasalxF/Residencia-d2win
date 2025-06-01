import React, { useState } from 'react';
import styles from './Calendar.module.css';

const Calendar = () => {
  const today = new Date();
  const [selectedDate, setSelectedDate] = useState(today.getDate());

  const year = today.getFullYear();
  const month = today.toLocaleString('pt-BR', { month: 'long' });
  const daysInMonth = new Date(year, today.getMonth() + 1, 0).getDate();

  const diasSemana = ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'];

  const handleSelectDate = (day) => {
    setSelectedDate(day);
  };

  return (
    <div className={styles.calendar}>
      <div className={styles.header}>
        <h1>{String(today.getDate()).padStart(2, '0')}</h1>
        <div>
          <span>{today.toLocaleString('pt-BR', { weekday: 'short' })}</span>
          <p>{month.charAt(0).toUpperCase() + month.slice(1)}, {year}</p>
        </div>
      </div>

      <div className={styles.diasSemana}>
        {diasSemana.map((dia, index) => (
          <span key={index}>{dia}</span>
        ))}
      </div>

      <div className={styles.dias}>
        {Array.from({ length: daysInMonth }, (_, i) => i + 1).map((dia) => (
          <button
            key={dia}
            onClick={() => handleSelectDate(dia)}
            className={selectedDate === dia ? styles.selected : ''}
          >
            {String(dia).padStart(2, '0')}
          </button>
        ))}
      </div>
    </div>
  );
};

export default Calendar;

// ← KCARRASCO
