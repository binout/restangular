/*
 * Copyright 2014 Benoit Prioux
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.thecodersbreakfast.restangular.server.rest.resource;

import net.thecodersbreakfast.restangular.server.dao.TodoRepository;
import net.thecodersbreakfast.restangular.server.model.Todo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/rest/todos")
public class TodoListResource {

    private TodoRepository repository = TodoRepository.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> list() {
        return repository.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Todo todo) throws IOException {
        repository.create(todo);
    }

}
