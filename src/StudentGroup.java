package epam;
import java.util.Date;
import java.util.*;
import java.lang.*;


/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
        int len = 0;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
            if(len != 0 ){
				ArrayList<Student> sl = new ArrayList<Student>();
  			   int i = 0;
  			   for(i=0;i<len;++i){
  					sl.add(students[i]);
  			   }
  			   
  			   int k = 0;
  				  Student bstud[] = new Student[sl.size()];
  				  
  				  for(Student s:sl){
  					  bstud[k]  = s;
  					  k++;
 				  }
				  
				  return bstud;
			}
                
            else return null;
	}

	@Override
	public void setStudents(Student[] students) {
               int i = 0;
		if(students == null)
                    throw new IllegalArgumentException();
                else {
					int j = len;
                    for(i=len;i<students.length;++i){
                        this.students[j] = students[i];
						j++;
                    }
                    len = len +students.length;
                }
	}



	@Override
	public Student getStudent(int index) {
		if(index >= len || index < 0 ){
                    throw new IllegalArgumentException();
		}
		else{
                    return students[index];
                }
	}



	@Override
	public void setStudent(Student student, int index) {
		if(student == null || index<0 || index>=len){
                  throw new IllegalArgumentException();
		}
		else{
                     students[index]=student;
		}
    }

	@Override
	public void addFirst(Student student) {
             if (student == null)
                 throw new IllegalArgumentException();
             int i =0;
             for(i=len;i > 0;--i){
                 students[i]  = students[i-1];
             }
             students[0] = student;
	}

	@Override
	public void addLast(Student student) {
		if (student == null)
                 throw new IllegalArgumentException();
                
                students[len] = student;
                len = len +1;
	}

	@Override
	public void add(Student student, int index) {
		if(student == null || index<0 || index>= len){
                        throw new IllegalArgumentException();
		}
		else{
                     int i =0;
                     for(i =len;i >index;--i){
                         students[i] = students[i-1];
                     }
                     students[i] = student;
                     len = len +1;
		}
	}

	@Override
	public void remove(int index) {
                int i = 0;
		if(index < 0 || index >= len){
                   throw new IllegalArgumentException();
                }
                else{
                    for(i= index;i<len-1;++i){
                        students[i] = students[i+1];
                    }
                    len = len-1;
                }

	}

	@Override
	public void remove(Student student) {
		if( student == null)
                    throw new IllegalArgumentException();
                int i = 0;
                for(i=0;i<len;++i){
                    if(students[i].getId() == student.getId()  &&  students[i].getFullName().equals(student.getFullName()) && students[i].getAvgMark() == student.getAvgMark() && students[i].getBirthDate().compareTo(student.getBirthDate()) == 0){
                        int  j = i;
                        for( j = i;j<len-1;++j){
                            students[j] = students[j+1];
                        }
                        break;
                    }
                }
                
                if(i == len){
                    throw new IllegalArgumentException("Student no exist");
                }
	}

	@Override
	public void removeFromIndex(int index) {
		if(index < 0 || index >= len){
                   throw new IllegalArgumentException();
                }
                else{
                    len = index+1;
                }
	}

	@Override
	public void removeFromElement(Student student) {
		if(student == null){
                   throw new IllegalArgumentException();
                }
                else{
                    int i =0;
                    for(i=0;i<len;++i){
                        if(students[i].getId() == student.getId()  &&  students[i].getFullName().equals(student.getFullName()) && students[i].getAvgMark() == student.getAvgMark() && students[i].getBirthDate().compareTo(student.getBirthDate()) == 0){
                            break;
                        }
                    }
                    if(i == len)
                         throw new IllegalArgumentException();
                    else
                       len = i +1;
                }
	}

	@Override
	public void removeToIndex(int index) {
		if(index < 0 || index >= len){
                   throw new IllegalArgumentException();
                }
                else{
                    int i = 0,j =0;
                    
                    for(i=index;i<len;++i){
                        students[j] = students[i];
                        j++;
                    }
                     len = len -index;
                } 
	}

	@Override
	public void removeToElement(Student student) {
		if(student == null){
                   throw new IllegalArgumentException();
                }
                else{
                    int i = 0;
                    for(i=0;i<len;++i){
                        if(students[i].getId() == student.getId()  &&  students[i].getFullName().equals(student.getFullName()) && students[i].getAvgMark() == student.getAvgMark() && students[i].getBirthDate().compareTo(student.getBirthDate()) == 0){
                            int j = 0;
                            int k = 0;
                            for(k=i;k<len;++k){
                                 students[j] = students[k];
                              k++;
                            }
                           len = len -i;
                           break;
                        }
                    }
                    if(i == len){
                        throw new IllegalArgumentException();
                    }
                }
	}

	@Override
	public void bubbleSort() {
		int i =0,j= 0;
		
		for(i = 0;i<len;++i){
			
			for(j=len-1;j >=i;j--){
				if(students[j].getId() < students[j-1].getId()){
					Student temp = students[j-1];
					students[j-1] = students[j];
					students[j] = temp;
				}
			}
			
		}
		
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		   if(date == null){
			   throw new IllegalArgumentException();
		   }
		   else{
			   ArrayList<Student> sl = new ArrayList<Student>();
			   int i = 0;
			   for(i=0;i<len;++i){
				   if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date)){
					   sl.add(students[i]);
				   }
			   }
			   
			   int k = 0;
				  Student bstud[] = new Student[sl.size()];
				  
				  for(Student s:sl){
					  bstud[k]  = s;
					  k++;
				  }
				  
				  return bstud;

		   } 
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		  if(firstDate == null || lastDate == null)
			  throw new IllegalArgumentException();
		  
		  int i =0;
		  ArrayList<Student> sl = new ArrayList<Student>();
		  
		  for(i=0;i<len;++i){
			  if((students[i].getBirthDate().after(firstDate) || students[i].getBirthDate().equals(firstDate)) && (students[i].getBirthDate().before(lastDate) ||students[i].getBirthDate().equals(lastDate))){
				    sl.add(students[i]);
			  }
		  }
		  
		  int k = 0;
		  Student bstud[] = new Student[sl.size()];
		  
		  for(Student s:sl){
			  bstud[k]  = s;
			  k++;
		  }
		  
		  return bstud;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		if(date == null)
			 throw new IllegalArgumentException();
		 int i =0;
		  ArrayList<Student> sl = new ArrayList<Student>();
		  
		  for(i=0;i<len;++i){
			  long diff = date.getTime() - date.getTime();
			  if(students[i].getBirthDate().after(date) && days == 4){
				    sl.add(students[i]);
			  }
		  }
		  
		  int k = 0;
		  Student bstud[] = new Student[sl.size()];
		  
		  for(Student s:sl){
			  bstud[k]  = s;
			  k++;
		  }
		  
		  return bstud;
		
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		
		if(indexOfStudent  < 0 || indexOfStudent >= len){
            throw new IllegalArgumentException();
         }
		Date date = students[indexOfStudent].getBirthDate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return 2017-year;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		int i =0;
		  ArrayList<Student> sl = new ArrayList<Student>();
		  
		  for(i=0;i<len;++i){
			  Date date = students[i].getBirthDate();
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				int year = calendar.get(Calendar.YEAR);
				
			  if(2017-year == age){
				    sl.add(students[i]);
			  }
		  }
		  
		  int k = 0;
		  Student bstud[] = new Student[sl.size()];
		  
		  for(Student s:sl){
			  bstud[k]  = s;
			  k++;
		  }
		  
		  return bstud;
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		
		int i =0;
		double avg = 0;
		for(i =0;i<len;++i){
			avg = avg + students[i].getAvgMark();
		}
		avg = avg/len;
		
		for(i=0;i<len;++i){
			ArrayList<Student> sl = new ArrayList<Student>();
			    i = 0;
			   for(i=0;i<len;++i){
				   if(avg == students[i].getAvgMark()){
					   sl.add(students[i]);
				   }
			   }
			   
			   int k = 0;
				  Student bstud[] = new Student[sl.size()];
				  
				  for(Student s:sl){
					  bstud[k]  = s;
					  k++;
				  }
				  
				  return bstud;

		}
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
          
	    if(student == null)
	    	throw new IllegalArgumentException();
		int i =0;
		for(i=0;i<len;++i){
			if(students[i].equals(student)){
				 break;
			}
		}
		
		return students[i+1];
	}
}