/*
 * Copyright 2012 JBoss Inc
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

package org.drools.planner.config.heuristic.selector.value;

import org.drools.planner.config.EnvironmentMode;
import org.drools.planner.config.heuristic.selector.common.SelectionOrder;
import org.drools.planner.config.heuristic.selector.value.ValueSelectorConfig;
import org.drools.planner.core.domain.entity.PlanningEntityDescriptor;
import org.drools.planner.core.domain.solution.SolutionDescriptor;
import org.drools.planner.core.heuristic.selector.common.SelectionCacheType;
import org.drools.planner.core.heuristic.selector.value.ValueSelector;
import org.drools.planner.core.heuristic.selector.value.FromSolutionPropertyValueSelector;
import org.drools.planner.core.heuristic.selector.value.decorator.CachingValueSelector;
import org.drools.planner.core.heuristic.selector.value.decorator.ShufflingValueSelector;
import org.drools.planner.core.testdata.domain.TestdataEntity;
import org.drools.planner.core.testdata.domain.TestdataSolution;
import org.junit.Test;

import static org.drools.planner.core.testdata.util.PlannerAssert.*;

public class ValueSelectorConfigTest {

    @Test
    public void phaseOriginal() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.PHASE);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.ORIGINAL);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(CachingValueSelector.class, valueSelector);
        assertNotInstanceOf(ShufflingValueSelector.class, valueSelector);
        assertInstanceOf(FromSolutionPropertyValueSelector.class,
                ((CachingValueSelector) valueSelector).getChildValueSelector());
    }

    @Test
    public void stepOriginal() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.STEP);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.ORIGINAL);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(CachingValueSelector.class, valueSelector);
        assertNotInstanceOf(ShufflingValueSelector.class, valueSelector);
        assertInstanceOf(FromSolutionPropertyValueSelector.class,
                ((CachingValueSelector) valueSelector).getChildValueSelector());
    }

    @Test
    public void justInTimeOriginal() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.JUST_IN_TIME);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.ORIGINAL);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(FromSolutionPropertyValueSelector.class, valueSelector);
    }

    @Test
    public void phaseRandom() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.PHASE);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.RANDOM);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(CachingValueSelector.class, valueSelector);
        assertNotInstanceOf(ShufflingValueSelector.class, valueSelector);
        assertInstanceOf(FromSolutionPropertyValueSelector.class,
                ((CachingValueSelector) valueSelector).getChildValueSelector());
    }

    @Test
    public void stepRandom() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.STEP);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.RANDOM);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(CachingValueSelector.class, valueSelector);
        assertNotInstanceOf(ShufflingValueSelector.class, valueSelector);
        assertInstanceOf(FromSolutionPropertyValueSelector.class,
                ((CachingValueSelector) valueSelector).getChildValueSelector());
    }

    @Test
    public void justInTimeRandom() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.JUST_IN_TIME);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.RANDOM);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(FromSolutionPropertyValueSelector.class, valueSelector);
    }

    @Test
    public void phaseShuffled() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.PHASE);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.SHUFFLED);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(ShufflingValueSelector.class, valueSelector);
        assertInstanceOf(FromSolutionPropertyValueSelector.class,
                ((ShufflingValueSelector) valueSelector).getChildValueSelector());
    }

    @Test
    public void stepShuffled() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.STEP);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.SHUFFLED);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
        assertInstanceOf(ShufflingValueSelector.class, valueSelector);
        assertInstanceOf(FromSolutionPropertyValueSelector.class,
                ((ShufflingValueSelector) valueSelector).getChildValueSelector());
    }

    @Test(expected = IllegalArgumentException.class)
    public void justInTimeShuffled() {
        SolutionDescriptor solutionDescriptor = TestdataSolution.buildSolutionDescriptor();
        PlanningEntityDescriptor entityDescriptor = solutionDescriptor.getPlanningEntityDescriptor(TestdataEntity.class);
        ValueSelectorConfig valueSelectorConfig = new ValueSelectorConfig();
        valueSelectorConfig.setCacheType(SelectionCacheType.JUST_IN_TIME);
        valueSelectorConfig.setSelectionOrder(SelectionOrder.SHUFFLED);
        ValueSelector valueSelector = valueSelectorConfig.buildValueSelector(
                EnvironmentMode.REPRODUCIBLE, solutionDescriptor, entityDescriptor,
                SelectionCacheType.JUST_IN_TIME, SelectionOrder.RANDOM);
    }

}
