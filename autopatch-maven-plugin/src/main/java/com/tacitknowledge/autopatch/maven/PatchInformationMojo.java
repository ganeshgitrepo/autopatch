package com.tacitknowledge.autopatch.maven;

/* Copyright 2006 Tacit Knowledge LLC
 * 
 * Licensed under the Tacit Knowledge Open License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.tacitknowledge.com/licenses-1.0.
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.MojoExecutionException;

import com.tacitknowledge.util.migration.jdbc.MigrationInformation;

/**
 * Goal which provides patch information.
 *
 * @goal info
 * @execute phase=compile
 * @requiresDependencyResolution compile
 */
public class PatchInformationMojo extends AbstractAutoPatchMojo
{
	public void execute() throws MojoExecutionException
    {
    	try 
    	{    		
    	    addClasspathElementsClassLoader();
            
        	MigrationInformation mi = new MigrationInformation();
    		mi.getMigrationInformation(systemName);
        }
        catch (Exception e) 
        {
        	getLog().error(e);
		}
    }
}