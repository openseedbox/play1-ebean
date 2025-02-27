package play.modules.ebean;

import java.util.Set;

import io.ebean.event.BeanPersistAdapter;
import io.ebean.event.BeanPersistRequest;

public class EbeanModelAdapter extends BeanPersistAdapter
{

  @Override
  public boolean isRegisterFor(Class<?> cls)
  {
    return EbeanSupport.class.isAssignableFrom(cls);
  }

  @Override
  public boolean preInsert(BeanPersistRequest<?> request)
  {
    ((EbeanSupport) request.getBean()).beforeSave(true);
    return true;
  }

  @Override
  public boolean preUpdate(BeanPersistRequest<?> request)
  {
    ((EbeanSupport) request.getBean()).beforeSave(false);
    return true;
  }

  @Override
  public void postInsert(BeanPersistRequest<?> request)
  {
    ((EbeanSupport) request.getBean()).afterSave(true);
  }

  @Override
  public void postUpdate(BeanPersistRequest<?> request)
  {
    ((EbeanSupport) request.getBean()).afterSave(false);
  }
  
  
}
