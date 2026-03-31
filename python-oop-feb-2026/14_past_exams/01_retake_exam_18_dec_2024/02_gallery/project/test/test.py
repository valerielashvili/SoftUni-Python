from unittest import TestCase, main
from project.gallery import Gallery


class TestGallery(TestCase):
    def setUp(self) -> None:
        self.gallery1 = Gallery("ArtGallery", "Sofia", 500, True)
        self.gallery2 = Gallery("ArtGallery", "Plovdiv", 400, False)

    def test_init_method(self):
        self.assertEqual(self.gallery1.gallery_name, "ArtGallery")
        self.assertEqual(self.gallery1.city, "Sofia")
        self.assertEqual(self.gallery1.area_sq_m, 500)
        self.assertEqual(self.gallery1.open_to_public, True)
        self.assertIsInstance(self.gallery1.exhibitions, dict)

    def test_name_setter(self):
        self.gallery1.gallery_name = "PublicGallery"
        self.assertEqual(self.gallery1.gallery_name, "PublicGallery")

        with self.assertRaises(ValueError) as e:
            self.gallery1.gallery_name = ";"
        self.assertEqual(str(e.exception), "Gallery name can contain letters and digits only!")

    def test_city_setter(self):
        self.gallery1.city = "Burgas"
        self.assertEqual(self.gallery1.city, "Burgas")

        with self.assertRaises(ValueError) as e:
            self.gallery1.city = ";a"
        self.assertEqual(str(e.exception), "City name must start with a letter!")

        with self.assertRaises(ValueError) as e:
            self.gallery1.city = ""
        self.assertEqual(str(e.exception), "City name must start with a letter!")

    def test_area_sq_m_setter(self):
        self.gallery1.area_sq_m = 100
        self.assertEqual(self.gallery1.area_sq_m, 100)

        with self.assertRaises(ValueError) as e:
            self.gallery1.area_sq_m = 0.0
        self.assertEqual(str(e.exception), "Gallery area must be a positive number!")

        with self.assertRaises(ValueError) as e:
            self.gallery1.area_sq_m = -1
        self.assertEqual(str(e.exception), "Gallery area must be a positive number!")

    def test_add_exhibition_method(self):
        exhibition_name = "Thracian Heritage"
        year = 2026
        result = self.gallery1.add_exhibition(exhibition_name, year)
        self.assertEqual(self.gallery1.exhibitions[exhibition_name], year)
        self.assertEqual(result, f'Exhibition "{exhibition_name}" added for the year {year}.')

        result = self.gallery1.add_exhibition(exhibition_name, year)
        self.assertEqual(result, f'Exhibition "{exhibition_name}" already exists.')

    def test_remove_exhibition_method(self):
        exhibition_name = "Some name"
        result = self.gallery1.remove_exhibition(exhibition_name)
        self.assertEqual(result, f'Exhibition "{exhibition_name}" not found.')

        exhibition_name = "Thracian Heritage"
        self.gallery1.add_exhibition("Thracian Heritage", 2026)
        result = self.gallery1.remove_exhibition(exhibition_name)
        self.assertEqual(result, f'Exhibition "{exhibition_name}" removed.')
        self.assertNotIn(exhibition_name, self.gallery1.exhibitions)

    def test_list_exhibitions(self):
        result = self.gallery1.list_exhibitions()
        expected_result = '\n'.join(f"{name}: {year}" for name, year in self.gallery1.exhibitions.items())
        self.assertEqual(result, expected_result)

        self.gallery1.open_to_public = False
        result = self.gallery1.list_exhibitions()
        self.assertEqual(
            result,
            f'Gallery {self.gallery1.gallery_name} is currently closed for public! Check for updates later on.'
        )


if __name__ == '__main__':
    main()
