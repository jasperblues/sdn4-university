/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package school.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "StudyBuddy")
public class StudyBuddy extends Entity {

    @Relationship(type="BUDDY")
    private List<Student> buddies;
    private Course course;
 //   private String description;

    public StudyBuddy(){
        buddies = new ArrayList<>();
    }

    public void setCourse( Course course )
    {
        this.course = course;
    }

    public void setBuddyTwo( Student buddyTwo )
    {
        buddies.add(buddyTwo);
    }

    public void setBuddyOne( Student buddyOne )
    {
        buddies.add(buddyOne);
    }

    public Course getCourse()
    {
        return course;
    }

    public Student getBuddyTwo()
    {
        if (buddies.size() > 1) {
            return buddies.get(1);
        } else {
            return null;
        }
    }

    public Student getBuddyOne()
    {
        if (buddies.size() > 0) {
            return buddies.get(0);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "StudyBuddy{" +
                "buddies= " + buddies.size() +
                ", course=" + course +
                '}';
    }

//    public String getDescription() {
//        return course.getName() + ", " + getBuddyOne().getName() + ", " + getBuddyTwo().getName();
//    }
//
//    public void setDescription(String description) {
//        // here as a convenience for JsonMapper
//    }
}
