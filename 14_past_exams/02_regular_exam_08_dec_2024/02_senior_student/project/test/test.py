from unittest import TestCase, main
from project.senior_student import SeniorStudent


class TestSeniorStudent(TestCase):
    def setUp(self):
        self.student1 = SeniorStudent("2785", "Mila", 4.0)
        self.student2 = SeniorStudent("2786", "Sergey", 3.8)

    def test_init(self):
        self.assertEqual(self.student1.student_id, "2785")
        self.assertEqual(self.student1.name, "Mila")
        self.assertEqual(self.student1.student_gpa, 4.0)
        self.assertEqual(set(), self.student1.colleges)
        self.assertIsInstance(self.student1.colleges, set)

    def test_student_id_setter(self):
        with self.assertRaises(ValueError) as e:
            self.student1.student_id = "278"

        self.assertEqual("Student ID must be at least 4 digits long!", str(e.exception))

    def test_student_id_setter_strip(self):
        self.student1.student_id = " 2786"
        self.assertEqual(self.student1.student_id, "2786")

    def test_student_name_setter(self):
        with self.assertRaises(ValueError) as e:
            self.student1.name = ""

        self.assertEqual("Student name cannot be null or empty!", str(e.exception))

    def test_student_gpa_setter(self):
        with self.assertRaises(ValueError) as e:
            self.student1.student_gpa = 0.0

        self.assertEqual("Student GPA must be more than 1.0!", str(e.exception))

    def test_apply_to_college_method(self):
        result = self.student1.apply_to_college(5.0, "SU")
        self.assertEqual(result, "Application failed!")
        self.assertNotIn("SU", self.student1.colleges)
        self.assertEqual(len(self.student1.colleges), 0)

        result = self.student1.apply_to_college(4.0, "SU")
        self.assertEqual(result, f"{self.student1.name} successfully applied to SU.")
        self.assertIn("SU", self.student1.colleges)

    def test_update_gpa_method(self):
        result = self.student1.update_gpa(0.0)
        self.assertEqual(result, "The GPA has not been changed!")
        self.assertEqual(self.student1.student_gpa, 4.0)

        result = self.student1.update_gpa(1.0)
        self.assertEqual(result, "The GPA has not been changed!")
        self.assertEqual(self.student1.student_gpa, 4.0)

        result = self.student1.update_gpa(5.0)
        self.assertEqual(result, "Student GPA was successfully updated.")
        self.assertEqual(5.0, self.student1.student_gpa)

    def test_equals_magic_method(self):
        self.assertFalse(self.student1 == self.student2)
        self.student2.student_gpa = 4.0
        self.assertTrue(self.student1 == self.student2)


if __name__ == "__main__":
    main()
