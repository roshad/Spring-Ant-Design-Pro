// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** 此处后端没有提供注释 GET /hello */
export async function hello(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.helloParams,
  options?: { [key: string]: any },
) {
  return request<string>('/hello', {
    method: 'GET',
    params: {
      // name has a default value: World
      name: 'World',
      ...params,
    },
    ...(options || {}),
  });
}
