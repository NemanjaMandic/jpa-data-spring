package com.courseapi.topic;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/teme")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/teme/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(value="/teme/", method = RequestMethod.POST)
	public void postTopic(@RequestBody Topic teme) {
		topicService.addTopic(teme);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/teme/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/teme/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
}
