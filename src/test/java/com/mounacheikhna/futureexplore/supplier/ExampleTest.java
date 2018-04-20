package com.mounacheikhna.futureexplore.supplier;

import com.mounacheikhna.futuresexplore.supplier.Dependency;
import com.mounacheikhna.futuresexplore.supplier.DependencyProvider;
import com.mounacheikhna.futuresexplore.supplier.Example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by mounacheikhna on 20/04/2018.
 */
public class ExampleTest {

    @Mock DependencyProvider mMockDependencyProvider;
    @Mock Dependency mMockDependency;

    private Example mExample;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(mMockDependencyProvider.provideDependency()).thenReturn(mMockDependency);
        mExample = new Example(mMockDependencyProvider);
    }

    @Test
    public void testPrintDependency() throws Exception {
        mExample.printDependency();
        verify(mMockDependency).print();
    }

}
