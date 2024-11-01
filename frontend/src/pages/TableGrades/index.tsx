import { CloseCircleOutlined } from '@ant-design/icons';
import { getAllGrades,createGrade,updateGrade,deleteGrade} from '@/services/ant-design-pro/gradeController';
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
  const columns: ProColumnType<API.Grade>[] = [
    {
      title: 'Student ID',
      dataIndex: 'studentId',
      key: 'studentId'
    },
    {
      title: 'Course ID',
      dataIndex: 'courseId',
      key: 'courseId'
    },
    {
      title: 'Grade ID',
      dataIndex: 'gradeId',
      key: 'gradeId'
    },
    {
      title: 'Score',
      dataIndex: 'score',
      key: 'score',
      sorter: (a,b)=>a.score - b.score
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
              console.log(record.gradeId);
              action?.startEditable(record.gradeId||0);
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
            <EditableProTable<API.Grade>
              recordCreatorProps={{
                position: 'top',
                record: () => {
                  return {
                    gradeId: (Math.random() * 1000000).toFixed(0), // 确保唯一，避免点不出来
                  };
                }


              }}

              request={getAllGrades}
              columns={columns}

              rowKey="gradeId"
              //ANCHOR - editable
              editable={{
                editableKeys,
                onSave: async (rowKey, editedRow,originRow) => {
                  console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                  if (typeof rowKey === 'string') {
                    // 新记录：创建操作
                    editedRow.gradeId=Number(editedRow.gradeId);
                    // console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                    try {
                      await createGrade(editedRow);
                      message.success('创建成功');
                      return true;
                    } catch (error) {
                      message.error('创建失败');
                      return false;
                    }
                  } else {
                    // 更新操作

                    try {
                      await updateGrade({ id: rowKey }, editedRow);
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
                    await deleteGrade({ id: key });
                    message.success('删除成功');
                    return true;
                  } catch (error) {
                    console.error('删除失败:', error);
                    message.error(`删除失败: ${error.message}`);
                    return false;
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
