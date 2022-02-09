import React from 'react';
import './App.css';
import ListContainer from './component/list-container/ListContainer';
import { Layout } from 'antd';
import SideBar from './component/sidebar/Sidebar';

const { Content } = Layout;

const App = () => {
  return(
    <div className="app">
      <Layout className="layout">
        <SideBar />
        <Content className="site-layout-content">
          <ListContainer />
        </Content>
      </Layout>
    </div>
  )
}

export default App;
