import React from 'react';
import Calendar from '../../components/common/Calendar/Calendar';
import { exportToExcel } from '../../services/exportExcel/exportExcel';
import styles from './DashboardPage.module.css';
import Header from '../../components/layout/Header/Header';
import Button from '../../components/common/Button/Button';
import {
  PieChart,
  Pie,
  Cell,
  Tooltip,
  ResponsiveContainer
} from 'recharts';


const DashboardPage = () => {
  const exportExcel = () => {
  const data = [
    { cliente: 'Cliente A', codigo: 401, erro: 'Unauthorized' },
    { cliente: 'Cliente B', codigo: 500, erro: 'Server Error' }
  ];

  exportToExcel(data, 'clientes-erros.xlsx');
};

const chartData = [
  { name: 'Erro Crítico', value: 107 },
  { name: 'Erro Médio', value: 69 },
  { name: 'Sem Erro', value: 0 }
];

const COLORS = ['#FF009A', '#FE96D1', '#E0E0E0'];



  return (
    <div>
      <Header />
      <main className={styles.dashboard}>
        <section className={styles.errorsCard}>
          <h2>Clientes e erros</h2>
          <table>
            <thead>
              <tr>
                <th>Nome do cliente</th>
                <th>Código</th>
                <th>Erro</th>
              </tr>
            </thead>
            <tbody>
              <tr><td>Cliente A</td><td>401</td><td>Unauthorized</td></tr>
              <tr><td>Cliente B</td><td>500</td><td>Server Error</td></tr>
            </tbody>
          </table>
          <Button label="Baixar Planilha" onClick={exportExcel} />
        </section>

        <section className={styles.chartCard}>
          <h2>Detalhamento</h2>
          <ResponsiveContainer width="100%" height={200}>
  <PieChart>
    <Pie
      data={chartData}
      dataKey="value"
      nameKey="name"
      cx="50%"
      cy="50%"
      outerRadius={60}
      fill="#8884d8"
      label
    >
      {chartData.map((entry, index) => (
        <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
      ))}
    </Pie>
    <Tooltip />
  </PieChart>
</ResponsiveContainer>
        </section>
        
        <section className={styles.calendarSection}>
  <Calendar />
</section>

      </main>
    </div>
  );
};

export default DashboardPage;