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

package org.activiti.crystalball.simulator.impl.cfg;

import org.activiti.crystalball.simulator.impl.interceptor.CommandContextInterceptor;
import org.activiti.crystalball.simulator.impl.interceptor.CommandInterceptor;
import org.activiti.crystalball.simulator.impl.interceptor.LogInterceptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * @author Tom Baeyens
 */
public class StandaloneSimulationEngineConfiguration extends SimulationEngineConfigurationImpl {

  protected Collection< ? extends CommandInterceptor> getDefaultCommandInterceptorsTxRequired() {
    return createDefaultCommandInterceptors(true);
  }
  
  protected Collection< ? extends CommandInterceptor> getDefaultCommandInterceptorsTxRequiresNew() {
    return createDefaultCommandInterceptors(false);
  }
  
  protected Collection< ? extends CommandInterceptor> createDefaultCommandInterceptors(boolean contextReusePossible) {
    List<CommandInterceptor> defaultCommandInterceptorsTxRequired = new ArrayList<CommandInterceptor>();
    defaultCommandInterceptorsTxRequired.add(new LogInterceptor());
    
    CommandContextInterceptor commandContextInterceptor = new CommandContextInterceptor(commandContextFactory, this);
    commandContextInterceptor.setContextReusePossible(contextReusePossible);
    defaultCommandInterceptorsTxRequired.add(commandContextInterceptor);
    
    return defaultCommandInterceptorsTxRequired;
  }
 
}