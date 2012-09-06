package com.ewerp.mud.commands;

import com.ewerp.engine.commands.ICommand;
import com.ewerp.engine.commands.IMessage;
import com.ewerp.engine.commands.Message;
import com.ewerp.engine.content.IContentSession;
import com.ewerp.engine.content.IContentSessionFactory;
import com.ewerp.engine.plugins.IPluginManager;
import com.ewerp.mud.content.Room;
import com.ewerp.mud.messages.metas.InformationMeta;

/**
 * Copyright 2012 Curtis Boyden
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class CreateRoomCommand extends EjMudCommand {
    @Override
    public void execute() throws IllegalStateException {
        if(null != getContentSession()) {
            Room room = new Room();

            getContentSession().store(room);
            getContentSession().commit();

            if(null != getSession()) {
                IMessage message = new Message();
                message.addMeta(new InformationMeta("Room successfully created"));
                getSession().processMessage(message);
            }
        } else {
            // TODO: Log
            System.out.println("What is going on?");
        }
    }
}
