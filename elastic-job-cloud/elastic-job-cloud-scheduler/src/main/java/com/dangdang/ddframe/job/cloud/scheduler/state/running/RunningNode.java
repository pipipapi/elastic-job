/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.cloud.scheduler.state.running;

import com.dangdang.ddframe.job.cloud.scheduler.state.StateNode;
import com.dangdang.ddframe.job.context.TaskContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 运行中任务节点路径.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class RunningNode {
    
    static final String ROOT = StateNode.ROOT + "/running";
    
    private static final String RUNNING_JOB = ROOT + "/%s"; // %s = ${JOB_NAME}
    
    private static final String RUNNING_TASK = RUNNING_JOB + "/%s"; // %s = ${TASK_META_INFO}。${TASK_META_INFO}=${JOB_NAME}@-@${ITEM_ID}。
    
    static String getRunningJobNodePath(final String jobName) {
        return String.format(RUNNING_JOB, jobName);
    }
    
    static String getRunningTaskNodePath(final String taskMetaInfo) {
        return String.format(RUNNING_TASK, TaskContext.MetaInfo.from(taskMetaInfo).getJobName(), taskMetaInfo);
    }
}
