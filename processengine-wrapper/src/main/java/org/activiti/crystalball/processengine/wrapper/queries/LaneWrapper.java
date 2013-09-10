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

package org.activiti.crystalball.processengine.wrapper.queries;

import java.util.ArrayList;
import java.util.List;

/** 
* A single lane in a BPMN 2.0 LaneSetWrapper, currently only used internally for rendering the
* diagram. The PVM doesn't actually use the laneSets/lanes.
* 
* @author Frederik Heremans
*/
public interface LaneWrapper extends HasDIBounds {
  public String getId();
  
  public String getName();
  

  public List<String> getFlowNodeIds();

}