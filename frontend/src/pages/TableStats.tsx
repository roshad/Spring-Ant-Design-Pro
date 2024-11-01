import { getClassStatistics } from '@/services/ant-design-pro/scoreController';
import type { ProColumnType } from '@ant-design/pro-components';
import { EditableProTable, PageContainer, ProForm } from '@ant-design/pro-components';
import { Card } from 'antd';
import type { FC } from 'react';

const AdvancedForm: FC<Record<string, any>> = () => {
  //ANCHOR columns

  const columns: ProColumnType<API.Class>[] = [
    {
      title: '班级名称',
      dataIndex: 'ClassName',
      key: 'ClassName',
    },
    {
      title: '通过学生数',
      dataIndex: 'passingStudents',
      key: 'passingStudents',
    },
    {
      title: '总学生数',
      dataIndex: 'totalStudents',
      key: 'totalStudents',
    },

    {
      title: '通过率 (%)',
      dataIndex: 'passingRate',
      key: 'passingRate',
      render: (text) => `${Number(text).toFixed(2)}%`, // 显示为百分比
    },
    {
      title: '平均分',
      dataIndex: 'averageScore',
      key: 'averageScore',
      render: (text) => Number(text).toFixed(2), // 显示小数点后两位
    },
  ];

  return (
    <PageContainer>
      <Card bordered={false}>
        <ProForm.Item name="members">
          <EditableProTable<API.Class>
            request={getClassStatistics}
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
