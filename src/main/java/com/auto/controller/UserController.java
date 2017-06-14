package com.auto.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auto.entity.Tuser;
import com.auto.service.UserService;

@RestController
@RequestMapping(value = "/user")
// 通过这里配置使下面的映射都在/Tusers下，可去除
public class UserController {
	static Map<Long, Tuser> tusers = Collections
			.synchronizedMap(new HashMap<Long, Tuser>());

	@Autowired
	private UserService userService;
	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = { "/getTuserList" }, method = RequestMethod.GET)
	public List<Tuser> getTuserList() {
		List<Tuser> r = userService.getList();
		return r;
	}

	@ApiOperation(value = "创建用户", notes = "根据Tuser对象创建用户")
	@ApiImplicitParam(name = "tusers", value = "用户详细实体Tuser", required = true, dataType = "Tuser")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postTuser(@RequestBody Tuser Tuser) {
		tusers.put(Tuser.getId(), Tuser);
		return "success";
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Tuser getTuser(@PathVariable Long id) {
		return tusers.get(id);
	}

	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的Tuser信息来更新用户详细信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "Tuser", value = "用户详细实体Tuser", required = true, dataType = "Tuser") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putTuser(@PathVariable Long id, @RequestBody Tuser Tuser) {
		Tuser u = tusers.get(id);
		u.setNickname(Tuser.getNickname());
		tusers.put(id, u);
		return "success";
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteTuser(@PathVariable Long id) {
		tusers.remove(id);
		return "success";
	}
}