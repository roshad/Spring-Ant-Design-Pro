// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** 此处后端没有提供注释 GET /api/classes */
export async function getAllClasses(options?: { [key: string]: any }) {
  return request<API.ApiResponseListClass>('/api/classes', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 POST /api/classes */
export async function createClass(body: API.Class, options?: { [key: string]: any }) {
  return request<API.ApiResponseClass>('/api/classes', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/classes/${param0} */
export async function getClassById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.getClassByIdParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.ApiResponseClass>(`/api/classes/${param0}`, {
    method: 'GET',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 PUT /api/classes/${param0} */
export async function updateClass(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.updateClassParams,
  body: API.Class,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.ApiResponseClass>(`/api/classes/${param0}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    params: { ...queryParams },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 DELETE /api/classes/${param0} */
export async function deleteClass(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.deleteClassParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.ApiResponseVoid>(`/api/classes/${param0}`, {
    method: 'DELETE',
    params: { ...queryParams },
    ...(options || {}),
  });
}
