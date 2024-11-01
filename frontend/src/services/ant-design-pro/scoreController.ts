// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** 此处后端没有提供注释 GET /api/scores/class-statistics */
export async function getClassStatistics(options?: { [key: string]: any }) {
  return request<API.ApiResponseListMapStringObject>('/api/scores/class-statistics', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/scores/table */
export async function getStudentScoresTable(options?: { [key: string]: any }) {
  return request<API.ApiResponseListMapStringObject>('/api/scores/table', {
    method: 'GET',
    ...(options || {}),
  });
}
