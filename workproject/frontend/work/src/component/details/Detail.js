import React, { useState } from "react";
import { Modal, Row, Col} from "antd";

const Detail = (props) => {
  return (
    <div className="detail">
      <Modal
        title="Thông tin công việc"
        visible={props.visitbleDetailForm}
        onCancel={props.handleCancel}
        onOk={props.handleCancel}
        width={400}
      >
        <Row gutter={24}>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Tên công việc:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                    Learn React
              </Col>
            </Row>
          </Col>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Id người thực hiện:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                    201
              </Col>
            </Row>
          </Col>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Id người tạo:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                    202
              </Col>
            </Row>
          </Col>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Ngày giao việc:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                01-01-2022
              </Col>
            </Row>
          </Col>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Ngày bắt đầu:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                01-01-2022
              </Col>
            </Row>
          </Col>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Ngày kết thúc:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                01-01-2022
              </Col>
            </Row>
          </Col>
          <Col className="gutter-row" span={24}>
            <Row gutter={24} style={{marginBottom:'10px'}}>
              <Col className="gutter-row" span={12}>
                  <b>Đánh giá:</b>
              </Col>
              <Col className="gutter-row" span={12}>
                5
              </Col>
            </Row>
          </Col>
        </Row>
      </Modal>
    </div>
  );
};

export default Detail;
