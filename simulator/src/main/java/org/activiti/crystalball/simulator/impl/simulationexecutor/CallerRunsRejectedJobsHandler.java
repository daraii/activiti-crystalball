/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.crystalball.simulator.impl.simulationexecutor;

import java.util.List;

/**
 * 
 * @author Daniel Meyer
 */
public class CallerRunsRejectedJobsHandler implements RejectedJobsHandler {

  public void jobsRejected(JobExecutor jobExecutor, List<String> jobIds) {
    // execute rejected work in caller thread (potentially blocking job acquisition)
    new ExecuteJobsRunnable(jobExecutor, jobIds).run();
  }

}
