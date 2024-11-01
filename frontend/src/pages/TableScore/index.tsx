import { getStudentScoresTable } from '@/services/ant-design-pro/scoreController';
import type { ProColumnType } from '@ant-design/pro-components';
import { EditableProTable, PageContainer, ProForm } from '@ant-design/pro-components';
import { Card } from 'antd';
import type { FC } from 'react';

const AdvancedForm: FC<Record<string, any>> = () => {
  //ANCHOR columns
  const columns: ProColumnType<API.Class>[] = [
    {
      title: '学生姓名',
      dataIndex: 'studentName',
      key: 'studentName',
    },

    {
      title: '语文',
      dataIndex: '语文',
      key: '语文',
    },
    {
      title: '数学',
      dataIndex: '数学',
      key: '数学',
    },
    {
      title: '物理',
      dataIndex: '物理',
      key: '物理',
    },
    {
      title: '化学',
      dataIndex: '化学',
      key: '化学',
    },
    {
      title: '总分',
      dataIndex: 'total',
      key: 'total',
    },
  ];

  return (
    <PageContainer>
      <Card bordered={false}>
        <ProForm.Item name="members">
          <EditableProTable<API.Class>
            request={getStudentScoresTable}
            columns={columns}
            recordCreatorProps={false}
            rowKey="classId"
            //ANCHOR - editable
          />
        </ProForm.Item>
      </Card>
    </PageContainer>
  );
};
export default AdvancedForm;
