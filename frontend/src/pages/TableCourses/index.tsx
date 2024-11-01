import { CloseCircleOutlined } from '@ant-design/icons';
import { getAllCourses,createCourse,updateCourse,deleteCourse} from '@/services/ant-design-pro/courseController';
import type { ProColumnType } from '@ant-design/pro-components';
import {
  EditableProTable,

  PageContainer,
  ProForm,

} from '@ant-design/pro-components';
import { Card, Col, message, Popover, Row } from 'antd';
import type { FC } from 'react';
import { useState } from 'react';


const AdvancedForm: FC<Record<string, any>> = () => {


  const [editableKeys, setEditableRowKeys] = useState<React.Key[]>([]);



  //ANCHOR columns
  const columns: ProColumnType<API.Course>[] = [
    {
      title: 'Course ID',
      dataIndex: 'courseId',
      key: 'courseId'
    },

    {
      title: '课程名',
      dataIndex: 'courseName',
      key: 'courseName'
    },
    {
      title: '操作',
      key: 'action',
      valueType: 'option',

      render: (_, record, index, action) => {
        return [
          <a
            key="editable"
            onClick={() => {
              console.log(record.courseId);
              action?.startEditable(record.courseId||0);
            }}
          >
            编辑
          </a>,
        ];
      },
    },
  ];

  return (
      <PageContainer>
        <Card  bordered={false}>
          <ProForm.Item name="members">
            <EditableProTable<API.Course>
              recordCreatorProps={{
                position: 'top',
                record: () => {
                  return {
                    courseId: `${(Math.random() * 1000000).toFixed(0)}`, // 添加唯一前缀避免混淆
                  };
                },
              }}

              request={getAllCourses}
              columns={columns}

              rowKey="courseId"
              //ANCHOR - editable
              editable={{
                editableKeys,
                onSave: async (rowKey, editedRow,originRow) => {
                  console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                  if (typeof rowKey === 'string') {
                    // 新记录：创建操作
                    editedRow.courseId=Number(editedRow.courseId);
                    // console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                    try {
                      await createCourse(editedRow);
                      message.success('创建成功');
                      return true;
                    } catch (error) {
                      message.error('创建失败');
                      return false;
                    }
                  } else {
                    // 更新操作

                    try {
                      await updateCourse({ id: rowKey }, editedRow);
                      message.success('更新成功');
                      return true;
                    } catch (error) {
                      message.error('更新失败');
                      return false;
                    }
                  }
                },
                onDelete: async (key, row) => {
                  if (typeof key === 'string') {

                    return false;
                  }
                  try {
                    await deleteCourse({ id: key });
                    message.success('删除成功');
                    return true;
                  } catch (error) {
                    console.error('删除失败:', error);
                    message.error(`删除失败: ${error.message}`);
                    return false;
                  }
                },
                onCancel: (key, record, originRow, newLine) => {
                  if (newLine) {
                    setEditableRowKeys((prev) => prev.filter((k) => k !== key));
                    message.info('取消新建');
                  }
                },
                onChange: setEditableRowKeys,
              }}
            />
          </ProForm.Item>
        </Card>
      </PageContainer>
  );
};
export default AdvancedForm;
