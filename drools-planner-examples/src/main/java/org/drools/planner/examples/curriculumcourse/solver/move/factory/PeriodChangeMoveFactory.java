/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package org.drools.planner.examples.curriculumcourse.solver.move.factory;

import java.util.ArrayList;
import java.util.List;

import org.drools.planner.core.heuristic.selector.move.factory.MoveListFactory;
import org.drools.planner.core.move.Move;
import org.drools.planner.core.solution.Solution;
import org.drools.planner.examples.curriculumcourse.domain.CurriculumCourseSchedule;
import org.drools.planner.examples.curriculumcourse.domain.Lecture;
import org.drools.planner.examples.curriculumcourse.domain.Period;
import org.drools.planner.examples.curriculumcourse.solver.move.PeriodChangeMove;

public class PeriodChangeMoveFactory implements MoveListFactory {

    public List<Move> createMoveList(Solution solution) {
        CurriculumCourseSchedule schedule = (CurriculumCourseSchedule) solution;
        List<Period> periodList = schedule.getPeriodList();
        List<Move> moveList = new ArrayList<Move>();
        for (Lecture lecture : schedule.getLectureList()) {
            for (Period period : periodList) {
                moveList.add(new PeriodChangeMove(lecture, period));
            }
        }
        return moveList;
    }

}
