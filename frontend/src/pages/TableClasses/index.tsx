
import { getAllClasses,createClass,updateClass,deleteClass} from '@/services/ant-design-pro/classController';
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
  const columns: ProColumnType<API.Class>[] = [
    {
      title: 'Class ID',
      dataIndex: 'classId',
      key: 'classId'
    },
    {
      title: '班名',
      dataIndex: 'className',
      key: 'className'
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
              // console.log(record.classId);
              action?.startEditable(record.classId||0);
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
            <EditableProTable<API.Class>
              recordCreatorProps={{
                position: 'top',
                record: () => {
                  return {
                    classId: (Math.random() * 1000000).toFixed(0), // 确保唯一，避免点不出来
                  };
                }


              }}

              request={getAllClasses}
              columns={columns}

              rowKey="classId"
              //ANCHOR - editable
              editable={{
                editableKeys,
                onSave: async (rowKey, editedRow,originRow) => {
                  console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                  if (typeof rowKey === 'string') {
                    // 新记录：创建操作
                    editedRow.classId=Number(editedRow.classId);
                    // console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                    try {
                      await createClass(editedRow);
                      message.success('创建成功');
                      return true;
                    } catch (error) {
                      message.error('创建失败');
                      return false;
                    }
                  } else {
                    // 更新操作

                    try {
                      console.log("rowKey",rowKey,typeof rowKey,editedRow,originRow);
                      await updateClass({ id: rowKey }, editedRow);
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
                    await deleteClass({ id: key });
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
