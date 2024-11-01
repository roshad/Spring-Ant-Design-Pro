// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** 此处后端没有提供注释 POST /api/clients */
export async function addClient(body: API.Client, options?: { [key: string]: any }) {
  return request<any>('/api/clients', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/clients/${param0} */
export async function getClient(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.getClientParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.Client>(`/api/clients/${param0}`, {
    method: 'GET',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 PUT /api/clients/${param0} */
export async function updateClient(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.updateClientParams,
  body: API.Client,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<any>(`/api/clients/${param0}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    params: { ...queryParams },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 DELETE /api/clients/${param0} */
export async function deleteClient(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.deleteClientParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<any>(`/api/clients/${param0}`, {
    method: 'DELETE',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/clients/all */
export async function getAllClients(options?: { [key: string]: any }) {
  return request<API.Client[]>('/api/clients/all', {
    method: 'GET',
    ...(options || {}),
  });
}
