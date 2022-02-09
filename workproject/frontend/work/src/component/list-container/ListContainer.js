import React, {useState} from 'react';
import { Table, Input, Space} from 'antd';
import 'antd/dist/antd.css';
import './ListContainer.css';
import DrawerTest from '../Drawer';
import Detail from '../details/Detail';

  const data = [
    {
      key: '1',
      name: 'John Brown',
      age: 32,
      address: 'New York No. 1 Lake Park',
      tags: ['nice', 'developer'],
    },
    {
      key: '4',
      name: 'John Brown',
      age: 32,
      address: 'New York No. 1 Lake Park',
      tags: ['nice', 'developer'],
    },
    {
      key: '2',
      name: 'Jim Green',
      age: 42,
      address: 'London No. 1 Lake Park',
      tags: ['loser'],
    },
    {
      key: '3',
      name: 'Joe Black',
      age: 32,
      address: 'Sidney No. 1 Lake Park',
      tags: ['cool', 'teacher'],
    },
    {
        key: '5',
        name: 'John Brown',
        age: 32,
        address: 'New York No. 1 Lake Park',
        tags: ['nice', 'developer'],
      },
      {
        key: '6',
        name: 'John Brown',
        age: 32,
        address: 'New York No. 1 Lake Park',
        tags: ['nice', 'developer'],
      },
      {
        key: '7',
        name: 'John Brown',
        age: 32,
        address: 'New York No. 1 Lake Park',
        tags: ['nice', 'developer'],
      },
      {
        key: '8',
        name: 'John Brown',
        age: 32,
        address: 'New York No. 1 Lake Park',
        tags: ['nice', 'developer'],
      },{
        key: '9',
        name: 'John Brown',
        age: 32,
        address: 'New York No. 1 Lake Park',
        tags: ['nice', 'developer'],
      }
  ];
  
const ListContainer = () => {
  const [visitbleDetailForm, setVisitbleDetailForm] = useState(false);

  const columns = [
    {
      title: 'Name',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: 'Age',
      dataIndex: 'age',
      key: 'age',
    },
    {
      title: 'Address',
      dataIndex: 'address',
      key: 'address',
    },
    {
      title: 'Country',
      dataIndex: 'Country',
      key: 'age',
    },
    {
      title: 'Action',
      key: 'action',
      render: (text, record) => (
        <Space size="middle">
          <a>Cập nhật</a>
          <a onClick={handleOpenDetailForm}>Xem chi tiết</a>
        </Space>
      ),
    },
  ];

  const handleOpenDetailForm = () => {
    setVisitbleDetailForm(true);
  }

  const handleCloseDetailForm = () => {
    setVisitbleDetailForm(false);
  }

  const rowSelection = {
    onChange: (selectedRowKeys: React.Key[], selectedRows: DataType[]) => {
      console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
    },
    getCheckboxProps: (record: DataType) => ({
      disabled: record.name === 'Disabled User', // Column configuration not to be checked
      name: record.name,
    }),
  };

    return(
        <div>
          <div className="action">
            <DrawerTest />
          </div>

          <div className="search">
            <Input.Search
              className="search__input"
            />
          </div>


        <Table rowSelection={{...rowSelection}} columns={columns} dataSource={data} pagination={{total:data.length, pageSize:5}}/>
        <Detail visitbleDetailForm={visitbleDetailForm} handleCancel={handleCloseDetailForm}/>
      </div>
    )
}

export default ListContainer;
