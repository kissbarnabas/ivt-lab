package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  TorpedoStore mockTorpedoStore;


  @BeforeEach
  public void init(){
    mockTorpedoStore = Mockito.mock(TorpedoStore.class);
    
    System.out.println(mockTorpedoStore.getTorpedoCount());
    this.ship = new GT4500(mockTorpedoStore, mockTorpedoStore);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTorpedoStore.isEmpty()).thenReturn(false);
    when(mockTorpedoStore.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockTorpedoStore, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTorpedoStore.isEmpty()).thenReturn(false);
    when(mockTorpedoStore.fire(1)).thenReturn(true);
    
    // Act
    ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockTorpedoStore, times(1)).fire(1);
  }

}
