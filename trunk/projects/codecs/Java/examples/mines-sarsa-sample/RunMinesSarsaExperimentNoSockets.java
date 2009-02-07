/*
 * Copyright 2008 Brian Tanner
 * http://rl-glue-ext.googlecode.com/
 * brian@tannerpages.com
 * http://brian.tannerpages.com
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 *  $Revision: 489 $
 *  $Date: 2009-01-31 14:34:21 -0700 (Sat, 31 Jan 2009) $
 *  $Author: brian@tannerpages.com $
 *  $HeadURL: https://rl-glue-ext.googlecode.com/svn/trunk/projects/codecs/Java/examples/skeleton/SkeletonExperiment.java $
 * 
 */
import org.rlcommunity.rlglue.codec.LocalGlue;
import org.rlcommunity.rlglue.codec.RLGlue;
import org.rlcommunity.rlglue.codec.AgentInterface;
import org.rlcommunity.rlglue.codec.util.EnvironmentLoader;
import org.rlcommunity.rlglue.codec.util.AgentLoader;
import org.rlcommunity.rlglue.codec.EnvironmentInterface;

/**
* A simple example of how can you run all components of the mines-sarsa project from a single Java class
* without using network sockets.  Because we remove the socket overhead, these experiments can execute
* many more steps per second (if they are computationally cheap).
*
* The great thing about this approach is that the experiment, agent, and environment are agnostic
* to how they are being used: locally or over the network.  This means they are still 100% RL-Glue
* portable and can be used together with any other language.
*/
public class RunMinesSarsaExperimentNoSockets{
	
	public static void main(String[] args){
		//Create the Agent
		AgentInterface theAgent=new SampleSarsaAgent();
		
		//Create the Environment
		EnvironmentInterface theEnvironment=new SampleMinesEnvironment();
		
		LocalGlue localGlueImplementation=new LocalGlue(theEnvironment,theAgent);
		RLGlue.setGlue(localGlueImplementation);
		
		
		//Run the main method of the Sample Experiment, using the arguments were were passed
		//This will run the experiment in the main thread.  The Agent and Environment will run
		//locally, without sockets.
		SampleExperiment.main(args);
		System.out.println("RunMinesSarsaExperimentNoSockets Complete");
		
	}

}