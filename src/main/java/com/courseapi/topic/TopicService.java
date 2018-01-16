package com.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics =  new ArrayList<>(Arrays.asList(
			new Topic("1", "Hari Haler", "On je lik"),
			new Topic("2", "Geri Gertruda", "ona je trudna"),
			new Topic("3", "Spring frejmvork", "Ljudi pa ovo i nije tako lose"),
			new Topic("java", "Ucenje Jave", "Ovo ti je da naucis javu"),
			new Topic("javascript", "Javaskript ucenje", "Nauci javuskript")
			));	
	
	public List<Topic> getAllTopics(){
		return topics;
		}
	
	public Topic getTopicById(final String id) {
		return topics
				.stream()
				.filter(t -> t.getId().equals(id))
				.findFirst()
				.get();
	}

	public void addTopic(Topic tema) {
		topics.add(tema);
		
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i ++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(e -> e.getId().equals(id));
	}
}






