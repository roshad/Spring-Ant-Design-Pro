import { List } from 'antd';
import React from 'react';

type Unpacked<T> = T extends (infer U)[] ? U : T;

const passwordStrength = {
  strong: <span className="strong">强</span>,
  medium: <span className="medium">中</span>,
  weak: <span className="weak">弱 Weak</span>,
};

const SecurityView: React.FC = () => {
  const getData = () => [
    {
      title: '账户密码',
      description: (
        <>
          当前密码强度：
          {passwordStrength.strong}
        </>
      ),
      actions: [<a key="Modify">修改</a>],
    },
    {
      title: '密保手机',
      description: `已绑定手机：138****8293`,
      actions: [<a key="Modify">修改</a>],
    },
    {
      title: '密保问题',
      description: '未设置密保问题，密保问题可有效保护账户安全',
      actions: [<a key="Set">设置</a>],
    },
    {
      title: '备用邮箱',
      description: `已绑定邮箱：ant***sign.com`,
      actions: [<a key="Modify">修改</a>],
    },
    {
      title: 'MFA 设备',
      description: '未绑定 MFA 设备，绑定后，可以进行二次确认',
      actions: [<a key="bind">绑定</a>,<a key="bind">123</a>],
    },
  ];
  const handleActionClick = (action: string) => {
    console.log(action);

    switch (action) {
      case '修改':
        console.log("处理修改逻辑");
        // 这里可以实现修改逻辑，比如弹出模态框
        break;
      case '设置':
        console.log("处理设置逻辑");
        // 这里可以实现设置密保问题的逻辑
        break;
      case '绑定':
        console.log("处理绑定逻辑");
        // 这里可以实现绑定MFA设备的逻辑
        break;
      default:
        break;
    }
  };
  const data = getData();
  return (
    <>
      <List<Unpacked<typeof data>>
        itemLayout="horizontal"
        dataSource={data}
        renderItem={(item) => (
          <List.Item actions={item.actions.map(action => (
            <a key={action.key} onClick={() => handleActionClick(action.key||"")}>
              {action}
            </a>
          ))} >
            <List.Item.Meta title={item.title} description={item.description}  />
          </List.Item>
        )}
      />
    </>
  );
};

export default SecurityView;
