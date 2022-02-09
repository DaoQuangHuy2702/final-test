import React, {useState} from 'react';
import { Drawer, Button, Popconfirm, Form, Input, InputNumber, DatePicker} from 'antd';
import 'antd/dist/antd.css';
import './Drawer.css';

const DrawerTest = () => {
    const [visible, setVisible] = useState(false);

    const showDrawer = () => {
        setVisible(true);
    };

    const onClose = () => {
        setVisible(false);
    };

    function onStartDateChange(date, dateString) {
        console.log(date, dateString);
    }

    function onEndDateChange(date, dateString) {
        console.log(date, dateString);
    }

    return(
        <div className="drawer">
            <>
                <Button type="primary" onClick={showDrawer} className="add-work-btn">
                    Thêm mới
                </Button>
                <Popconfirm
                    okText="Có"
                    cancelText="Không"
                    title="Bạn có muốn xóa không?"
                    style={{display: 'inline'}}
                    >
                    <Button type="primary" className="action__btn">
                        Xóa
                    </Button>
                </Popconfirm>
                <Drawer title="Basic Drawer" onClose={onClose} visible={visible} placement="right" width="500">
                    <Form
                        name="basic"
                        labelCol={{
                        span: 8,
                        }}
                        wrapperCol={{
                        span: 16,
                        }}
                        initialValues={{
                            remember: true,
                        }}
                        autoComplete="off"
                        onFinish={onClose}
                    >
                        <Form.Item
                        label="Tên công việc"
                        name="name"
                        rules={[
                            {
                            required: true,
                            message: "Vui lòng nhập tên công việc!",
                            },
                        ]}

                        >
                            <Input placeholder={"Nhập tên công việc"} />
                        </Form.Item>

                        <Form.Item
                        label="ID người thực hiện"
                        name="assigneId"
                        rules={[
                            {
                            type: "number",
                            min: 1,
                            required: true,
                            message: "Vui lòng nhập ID người thực hiện!",
                            },
                        ]}
                    
                        >
                            <InputNumber placeholder={"Nhập ID người thực hiện"} style={{width: "100%"}}/>
                        </Form.Item>

                        <Form.Item
                        label="ID người tạo"
                        name="creatorId"
                        rules={[
                            {
                            type: "number",
                            min: 1,
                            required: true,
                            message: "Vui lòng nhập ID người tạo!",
                            },
                        ]}
                    
                        >
                            <InputNumber placeholder={"Nhập ID người tạo"} style={{width: "100%"}}/>
                        </Form.Item>

                        <Form.Item
                        label="Ngày bắt đầu"
                        name="startDate"
                        rules={[
                            {
                            required: true,
                            message: "Vui lòng nhập ngày bắt đầu!",
                            },
                        ]}
                        >
                            <DatePicker onChange={onStartDateChange} />
                        </Form.Item>

                        <Form.Item
                        label="Ngày kết thúc"
                        name="endDate"
                        rules={[
                            {
                            required: true,
                            message: "Vui lòng nhập ngày kết thúc!",
                            },
                        ]}
                        >
                            <DatePicker onChange={onEndDateChange} />
                        </Form.Item>

                        <Form.Item
                        label="Đánh giá"
                        name="rate"
                        rules={[
                            {
                            type: "number",
                            min: 1,
                            max: 10,
                            required: true,
                            message: "Vui lòng nhập đánh giá!",
                            },
                        ]}
                    
                        >
                            <InputNumber placeholder={"Nhập đánh giá"} style={{width: "100%"}}/>
                        </Form.Item>

                        <Form.Item
                        wrapperCol={{
                            offset: 8,
                            span: 16,
                        }}
                        >
                        <Button type="primary" htmlType="submit">
                            Thêm công việc
                        </Button>
                        </Form.Item>
                    </Form>

                </Drawer>
            </>
        </div>
    )
}

export default DrawerTest